/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import java.util.Map;

/**
 *
 * @author Julian David Devia Serna
 */
public interface ModulesPersistence {
    
    /**
     *
     * @param name the name of the module to check
     * @return true if the module exits, false otherwise
     */
    public boolean checkModule(String name);
    
    /**
     *
     * @param mod the module to add
     * @throws ModuleException if the module already exists
     */
    public void addModule(Module mod) throws ModuleException;
    
    /**
     *
     * @return all the registered modules
     */
    public Map<String,Module> getModules();
    
    /**
     *
     * @param name the name of the wanted module
     * @return the requested module
     * @throws ModuleException if the module doesn't exits
     */
    public Module getModule(String name) throws ModuleException;
    
    /**
     *
     * @param oldName the old name of the module to update
     * @param mod the current module
     * @throws ModuleException if the oldName is not registered or the name of mod already exists
     */
    public void updateModule(String oldName,Module mod) throws ModuleException;
}
