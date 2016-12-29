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
import java.util.Date;
import java.util.HashMap;
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
        }
        throw new ModuleException("The module already exists");

    }

    @Override
    public Map<String, Module> getModules() {
        return modulos;
    }

    @Override
    public Module getModule(String name) throws ModuleException {
        if (checkModule(name)) {
            return modulos.get(name);
        }
        throw new ModuleException("The module doesn't exits");
    }

    @Override
    public void updateModule(String oldName, Module mod) throws ModuleException {
        if (checkModule(oldName)) {
            addModule(mod);
            modulos.remove(oldName);
        }
        throw new ModuleException("The module doesn't exists");
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
        User u= new User();
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
        try {
            pers.addModule(mod);
        } catch (ModuleException ex) {
            Logger.getLogger(InMemoryModulesPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
