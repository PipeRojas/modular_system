/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.Development;
import edu.eci.researchgroup.modularsystem.model.End;
import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.model.Start;
import edu.eci.researchgroup.modularsystem.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian David Devia Serna
 */
@Service
public class InMemoryModulesPersistence implements ModulesPersistence {

    private HashMap<String, Module> modulos;

    public InMemoryModulesPersistence() {
        modulos = new HashMap<>();
        InMemoryModulesPersistence.staticModules(this);
    }

    @Override
    public boolean checkModule(String name) {
        return modulos.containsKey(name);
    }

    @Override
    public void addModule(Module mod) throws ModuleException {
        if (!checkModule(mod.getName())) {
            modulos.put(mod.getName(), mod);
        } else {
            throw new ModuleException("The module already exists");
        }
    }

    @Override
    public Map<String, Module> getModules() {
        return modulos;
    }

    @Override
    public Module getModule(String name) throws ModuleException {
        if (checkModule(name)) {
            return modulos.get(name);
        } else {
            throw new ModuleException("The module doesn't exits");
        }
    }

    @Override
    public void updateModule(String oldName, Module mod) throws ModuleException {
        if (checkModule(oldName)) {
            addModule(mod);
            modulos.remove(oldName);
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    @Override
    public void addDocumentToStartModule(String uri, String name) throws ModuleException {
        if (checkModule(name)) {
            modulos.get(name).addStartDocument(uri);
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    @Override
    public void addDocumentToDevelopmentModule(String uri, String name) throws ModuleException {
        if (checkModule(name)) {
            modulos.get(name).addDevelopmentDocument(uri);
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    @Override
    public void addRemarkToModule(String remark, String name) throws ModuleException {
        if (checkModule(name)) {
            modulos.get(name).addRemark(remark);
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    @Override
    public void addSubModuleToModule(Module subModule, String name) throws ModuleException {
        if (checkModule(name)) {
            if(!checkModule(subModule.getName())){
                addModule(subModule);
            }
            modulos.get(name).addSubModule(subModule);
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    @Override
    public Map<String, Module> getMainModules() {
        Map<String,Module> main= new HashMap<>();
        for(Module actual:modulos.values()){
            boolean isSubModule=false;
            for(Module otro:modulos.values()){
                isSubModule=isSubModule || otro.hasSubModule(actual);
                if(isSubModule){
                    break;
                }
            }
            if(!isSubModule){
                main.put(actual.getName(), actual);
            }
        }
        return main;
    }
    
    public static void staticModules(InMemoryModulesPersistence pers) {
        Start s = new Start();
        s.setEstimateDate(new Date());
        s.setFrequency(true);
        s.setSelection("A");
        s.setText("B");
        Development d = new Development();
        d.setSelection("A");
        d.setText("B");
        End e = new End();
        e.setSelection("a");
        e.setText("b");
        e.setStartAndDevelopmentRemarks("c");
        User u = new User();
        u.setName("user");
        u.setSelection("a");
        u.setText("b");
        Module mod = new Module();
        mod.setInitialDate(new Date());
        mod.setIteration(true);
        mod.setName("module");
        mod.setStart(s);
        mod.setDevelopment(d);
        mod.setEnd(e);
        mod.setOwner(u);

        Start s2 = new Start();
        s2.setEstimateDate(new Date());
        s2.setFrequency(true);
        s2.setSelection("1");
        s2.setText("2");
        Development d2 = new Development();
        d2.setSelection("1");
        d2.setText("2");
        End e2 = new End();
        e2.setSelection("1");
        e2.setText("2");
        e2.setStartAndDevelopmentRemarks("1");
        User u2 = new User();
        u2.setName("user");
        u2.setSelection("a");
        u2.setText("b");
        Module subMod = new Module();
        subMod.setInitialDate(new Date());
        subMod.setIteration(true);
        subMod.setName("sub-module");
        subMod.setStart(s2);
        subMod.setDevelopment(d2);
        subMod.setEnd(e2);
        subMod.setOwner(u2);
        try {
            pers.addModule(mod);
            pers.addSubModuleToModule(subMod, mod.getName());
        } catch (ModuleException ex) {
            Logger.getLogger(InMemoryModulesPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
