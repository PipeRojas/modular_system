/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import java.util.List;

/**
 *
 * @author Julian David Devia Serna
 */
public interface DAOModules {

    /**
     * Loads all the registered modules
     *
     * @return all the registered modules
     */
    public List<Module> loadAll();

    /**
     * Load the module with the given name
     *
     * @param name the name of the module to load
     * @return the selected module
     * @throws ModuleException if the name is null
     */
    public Module load(String name) throws ModuleException;

    /**
     * Loads all the main modules, all which aren't submodules of other modules
     *
     * @return all the main modules, all which aren't submodules of other
     * modules
     */
    public List<Module> loadMain();

    /**
     * Loads all the modules which have registered with the given user as its
     * owner
     *
     * @param userName the name of the owner of the modules
     * @return all the modules which have registered with the given user as its
     * owner
     * @throws ModuleException if the userName is null
     */
    public List<Module> loadByUser(String userName) throws ModuleException;

    /**
     * Loads all the main modules which have registered with the given user as
     * its owner
     *
     * @param userName the name of the owner of the modules
     * @return all the main modules which have registered with the given user as
     * its owner
     * @throws ModuleException if the userName is null
     */
    public List<Module> loadMainByUser(String userName) throws ModuleException;

    /**
     * Registers the given module
     *
     * @param module the module to be registered
     * @throws ModuleException if the module is null
     */
    public void save(Module module) throws ModuleException;

    /**
     * Updates the module with the oldName with all the new information
     *
     * @param oldName the name of the module before the changes
     * @param module the module with the current information
     * @throws ModuleException if the oldName is null or the module is null or
     * the module with the oldName isn't registered yet
     */
    public void update(String oldName, Module module) throws ModuleException;

    /**
     * Adds a document's uri to the start phase of the module
     *
     * @param name the name of the module
     * @param uri the document's uri
     * @throws ModuleException if the name or the uri is null or if the module
     * with the given name isn't registered yet
     */
    public void addDocumentStart(String name, String uri) throws ModuleException;

    /**
     * Adds a document's uri to the development phase of the module
     *
     * @param name the name of the module
     * @param uri the document's uri
     * @throws ModuleException if the name or the uri is null or if the module
     * with the given name isn't registered yet
     */
    public void addDocumentDev(String name, String uri) throws ModuleException;

    /**
     * Adds a remark to the module
     *
     * @param name the name of the module
     * @param remark the remark
     * @throws ModuleException if the name or the remark is null or if the
     * module with the given name isn't registered yet
     */
    public void addRemark(String name, String remark) throws ModuleException;

    /**
     * Adds a module as a submodule of the development phase of another module
     *
     * @param subModule the module o be registered as a submodule
     * @param name the name of the module which has subModule
     * @throws ModuleException if the name or the subModule is null or if the
     * module with the given name isn't registered yet
     */
    public void addSubModule(Module subModule, String name) throws ModuleException;

}
