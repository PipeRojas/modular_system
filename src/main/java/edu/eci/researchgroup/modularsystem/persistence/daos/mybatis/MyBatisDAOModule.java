/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOModules;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.ModuleMapper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Julian David Devia Serna
 */
public class MyBatisDAOModule implements DAOModules {

    private SqlSession ses;
    private ModuleMapper mmap;

    public MyBatisDAOModule(SqlSession ses) {
        this.ses = ses;
        mmap = ses.getMapper(ModuleMapper.class);
    }

    /**
     * Builds a module loading its submodules
     *
     * @param mod the module to be build
     * @return the module with all its submodules
     */
    private Module buildModule(Module mod) {
        Deque<Module> stack = new ArrayDeque<>();
        stack.addLast(mod);
        while (!stack.isEmpty()) {
            Module current = stack.pollFirst();
            List<Module> subMod = mmap.loadSubMod(current.getName());
            current.getDevelopment().setSubModules(subMod);
            for (Module module : subMod) {
                stack.addLast(module);
            }
        }
        return mod;
    }

    @Override
    public Map<String, Module> loadAll() {
        List<Module> all = mmap.loadAll();
        Map<String, Module> fullMod = new HashMap<>();
        for (Module mod : all) {
            fullMod.put(mod.getName(), buildModule(mod));
        }
        return fullMod;
    }

    @Override
    public Module load(String name) throws ModuleException {
        if (name == null || name.length() == 0) {
            throw new ModuleException("The module name must't be null");
        }
        Module mod = mmap.load(name);
        return buildModule(mod);
    }

    @Override
    public Map<String, Module> loadMain() {
        List<Module> main = mmap.loadMain();
        Map<String, Module> fullMod = new HashMap<>();
        for (Module mod : main) {
            fullMod.put(mod.getName(), buildModule(mod));
        }
        return fullMod;
    }

    @Override
    public Map<String, Module> loadByUser(String userName) throws UserException {
        if (userName == null || userName.length() == 0) {
            throw new UserException("The user name must't be null");
        }
        List<Module> user = mmap.loadByUser(userName);
        Map<String, Module> fullMod = new HashMap<>();
        for (Module mod : user) {
            fullMod.put(mod.getName(), buildModule(mod));
        }
        return fullMod;
    }

    @Override
    public Map<String, Module> loadMainByUser(String userName) throws UserException {
        if (userName == null || userName.length() == 0) {
            throw new UserException("The user name must't be null");
        }
        List<Module> user = mmap.loadMainByUser(userName);
        Map<String, Module> fullMod = new HashMap<>();
        for (Module mod : user) {
            fullMod.put(mod.getName(), buildModule(mod));
        }
        return fullMod;
    }

    @Override
    public void save(Module module) throws ModuleException {
        if (module == null) {
            throw new ModuleException("The module must't be null");
        }
        if (mmap.load(module.getName()) != null) {
            throw new ModuleException("The module is already registered");
        }
        mmap.insertModule(module);
        for (String remark : module.getRemarks()) {
            addRemark(module.getName(), remark);
        }
        for (String uri : module.getStart().getDocuments()) {
            addDocumentStart(module.getName(), uri);
        }
        for (String uri : module.getDevelopment().getDocuments()) {
            addDocumentDev(module.getName(), uri);
        }
        for (Module subMod : module.getDevelopment().getSubModules()) {
            addSubModule(subMod, module.getName());
        }
    }

    @Override
    public void update(String oldName, Module module) throws ModuleException {
        if (module == null) {
            throw new ModuleException("The module must't be null");
        }
        if (oldName == null || oldName.length() == 0) {
            throw new ModuleException("The user name must't be null");
        }
        Module old=load(oldName);
        if (old == null) {
            throw new ModuleException("The module isn't registered yet");
        }
        mmap.updateModule(oldName, module);
        for(String oldRemark : old.getRemarks()){
            if(!module.getRemarks().contains(oldRemark)){
                mmap.deleteRemark(oldName, oldRemark);
            }
        }
        for(String newRemark : module.getRemarks()){
            if(!old.getRemarks().contains(newRemark)){
                addRemark(module.getName(), newRemark);
            }
        }
        for(String oldUri : old.getStart().getDocuments()){
            if(!module.getStart().getDocuments().contains(oldUri)){
                mmap.deleteStartDoc(oldName, oldUri);
            }
        }
        for(String newUri : module.getStart().getDocuments()){
            if(!old.getStart().getDocuments().contains(newUri)){
                addDocumentStart(oldName, newUri);
            }
        }
        for(String oldUri : old.getDevelopment().getDocuments()){
            if(!module.getDevelopment().getDocuments().contains(oldUri)){
                mmap.deleteDevDoc(oldName, oldUri);
            }
        }
        for(String newUri : module.getDevelopment().getDocuments()){
            if(!old.getDevelopment().getDocuments().contains(newUri)){
                addDocumentDev(oldName, newUri);
            }
        }
        for(Module oldSubMod : old.getDevelopment().getSubModules()){
            if(!module.getDevelopment().getSubModules().contains(oldSubMod)){
                mmap.deleteSubMod(oldName, oldSubMod.getName());
            }
        }
        for(Module newSubMod : module.getDevelopment().getSubModules()){
            if(!module.getDevelopment().getSubModules().contains(newSubMod)){
                addSubModule(newSubMod, oldName);
            }
        }
        
    }

    @Override
    public void addDocumentStart(String name, String uri) throws ModuleException {
        if (name == null) {
            throw new ModuleException("The module name must't be null");
        }
        if (uri == null) {
            throw new ModuleException("The uri must't be null");
        }
        if (mmap.load(name) == null) {
            throw new ModuleException("The module isn't registered yet");
        }
        mmap.insertDocStart(name, uri);
    }

    @Override
    public void addDocumentDev(String name, String uri) throws ModuleException {
        if (name == null) {
            throw new ModuleException("The module name must't be null");
        }
        if (uri == null) {
            throw new ModuleException("The uri must't be null");
        }
        if (mmap.load(name) == null) {
            throw new ModuleException("The module isn't registered yet");
        }
        mmap.insertDocDev(name, uri);
    }

    @Override
    public void addRemark(String name, String remark) throws ModuleException {
        if (name == null) {
            throw new ModuleException("The module name must't be null");
        }
        if (remark == null) {
            throw new ModuleException("The remark must't be null");
        }
        if (mmap.load(name) == null) {
            throw new ModuleException("The module isn't registered yet");
        }
        mmap.insertRemark(name, remark);
    }

    @Override
    public void addSubModule(Module subModule, String name) throws ModuleException {
        if (name == null) {
            throw new ModuleException("The module name must't be null");
        }
        if (subModule == null) {
            throw new ModuleException("The submodule must't be null");
        }
        if (mmap.load(name) == null) {
            throw new ModuleException("The module isn't registered yet");
        }
        if (mmap.load(subModule.getName()) == null) {
            save(subModule);
        }
        mmap.insertSubModule(name, subModule.getName());
    }
}
