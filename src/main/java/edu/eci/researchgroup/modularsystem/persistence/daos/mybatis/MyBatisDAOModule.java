/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOModules;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.ModuleMapper;
import java.util.List;
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

    @Override
    public List<Module> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Module load(String name) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Module> loadMain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Module> loadByUser(String userName) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Module> loadMainByUser(String userName) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Module module) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String oldName, Module module) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDocumentStart(String name, String uri) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDocumentDev(String name, String uri) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRemark(String name, String remark) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSubModule(Module subModule, String name) throws ModuleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
