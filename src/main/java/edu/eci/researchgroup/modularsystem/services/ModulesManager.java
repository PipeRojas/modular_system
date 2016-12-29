/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.services;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.persistence.ModulesPersistence;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian David Devia Serna
 */
@Service
public class ModulesManager {
    
    @Autowired
    private ModulesPersistence persist;

    /**
     * @return the persist
     */
    public ModulesPersistence getPersist() {
        return persist;
    }

    /**
     * @param persist the persist to set
     */
    public void setPersist(ModulesPersistence persist) {
        this.persist = persist;
    }
    
    /**
     *
     * @param name the name of the module to check
     * @return true if the module exits, false otherwise
     */
    public boolean checkModule(String name){
        return persist.checkModule(name);
    }
    
    /**
     *
     * @param mod the module to add
     * @throws ModuleException if the module already exists
     */
    public void addModule(Module mod) throws ModuleException{
        persist.addModule(mod);
    }
    
    /**
     *
     * @return all the registered modules
     */
    public Map<String,Module> getModules(){
        return persist.getModules();
    }
    
    /**
     *
     * @param name the name of the wanted module
     * @return the requested module
     * @throws ModuleException if the module doesn't exits
     */
    public Module getModule(String name) throws ModuleException{
        return persist.getModule(name);
    }
    
    /**
     *
     * @param oldName the old name of the module to update
     * @param mod the current module
     * @throws ModuleException if the oldName is not registered or the name of mod already exists
     */
    public void updateModule(String oldName,Module mod) throws ModuleException{
        persist.updateModule(oldName, mod);
    }
    
}
