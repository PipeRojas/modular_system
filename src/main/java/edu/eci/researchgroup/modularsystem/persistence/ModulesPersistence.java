/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.model.UserException;
import java.util.Map;

/**
 *
 * @author Julian David Devia Serna
 */
public interface ModulesPersistence {

    /**
     * Checks if a module is registered or not
     *
     * @param name the name of the module to check
     * @return true if the module exists, false otherwise
     */
    public boolean checkModule(String name);

    /**
     * Registers a module
     *
     * @param mod the module to add
     * @throws ModuleException if the module already exists
     */
    public void addModule(Module mod) throws ModuleException;

    /**
     * Returns all the registered modules
     *
     * @return all the registered modules
     */
    public Map<String, Module> getModules();

    /**
     * Finds a module given its name
     *
     * @param name the name of the wanted module
     * @return the requested module
     * @throws ModuleException if the module doesn't exits
     */
    public Module getModule(String name) throws ModuleException;

    /**
     * Updates a module with all the new given information
     *
     * @param oldName the old name of the module to update
     * @param mod the current module
     * @throws ModuleException if the oldName is not registered or the name of
     * mod already exists
     */
    public void updateModule(String oldName, Module mod) throws ModuleException;

    /**
     * Adds a file to the start phase of the selected module
     *
     * @param uri the uri of the file to be added to the start phase of the
     * module
     * @param name the name of the selected module
     * @throws ModuleException if the module doesn't exists
     */
    public void addDocumentToStartModule(String uri, String name) throws ModuleException;

    /**
     * Adds a file to the development phase of the selected module
     *
     * @param uri the uri of the file to be added to the development phase of
     * the module
     * @param name the name of the selected module
     * @throws ModuleException if the module doesn't exists
     */
    public void addDocumentToDevelopmentModule(String uri, String name) throws ModuleException;

    /**
     * Adds a remark to the selected module
     *
     * @param remark the remark to be added to the module
     * @param name the name of the selected module
     * @throws ModuleException if the module doesn't exists
     */
    public void addRemarkToModule(String remark, String name) throws ModuleException;

    /**
     * Adds a module as a submodule of the development phase of the selected
     * module
     *
     * @param subModule the sub-module to be added to the module
     * @param name the name of the selected module
     * @throws ModuleException if the module doesn't exists
     */
    public void addSubModuleToModule(Module subModule, String name) throws ModuleException;

    /**
     * Returns the main modules, those which aren't submodules of other modules
     *
     * @return the main modules, those who aren't submodules of other modules
     */
    public Map<String, Module> getMainModules();

    /**
     * Returns all the modules which have user as its owner
     *
     * @param userName the name of the user who owns the modules
     * @return all the modules which have user as its owner
     * @throws UserException if the user isn't registered
     */
    public Map<String, Module> getModulesByUser(String userName) throws UserException;

    /**
     * Returns all the the main modules, those which aren't submodules of other
     * modules which have user as its owner
     *
     * @param userName the name of the user who owns the modules
     * @return all the the main modules, those which aren't submodules of other
     * modules which have user as its owner
     * @throws UserException if the user isn't registered
     */
    public Map<String, Module> getMainModulesByUser(String userName) throws UserException;
}
