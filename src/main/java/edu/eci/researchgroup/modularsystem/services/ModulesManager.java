/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.services;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.persistence.ModulesPersistence;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * Sets a persistence component to the manager
     *
     * @param persist the persist to set
     */
    public void setPersist(ModulesPersistence persist) {
        this.persist = persist;
    }

    /**
     * Checks if a module is registered or not
     *
     * @param name the name of the module to check
     * @return true if the module exits, false otherwise
     */
    public boolean checkModule(String name) {
        return persist.checkModule(name);
    }

    /**
     * Registers a module
     *
     * @param mod the module to add
     * @throws ModuleException if the module already exists
     */
    public void addModule(Module mod) throws ModuleException {
        persist.addModule(mod);
    }

    /**
     * Returns all the registered modules
     *
     * @return all the registered modules
     */
    public Map<String, Module> getModules() {
        return persist.getModules();
    }

    /**
     * Returns the selected module given its name
     *
     * @param name the name of the wanted module
     * @return the requested module
     * @throws ModuleException if the module doesn't exits
     */
    public Module getModule(String name) throws ModuleException {
        return persist.getModule(name);
    }

    /**
     * Updates an existing module based in its old name with all new information
     * given
     *
     * @param oldName the old name of the module to update
     * @param mod the current module
     * @throws ModuleException if the oldName is not registered or the name of
     * mod already exists
     */
    public void updateModule(String oldName, Module mod) throws ModuleException {
        persist.updateModule(oldName, mod);
    }

    /**
     * Adds a file to the start phase of the selected module
     *
     * @param name the name of the module selected
     * @param file the file to be uploaded to he start phase
     * @throws ModuleException if the module doesn't exists or there is an error
     * while saving the file
     */
    public void addFileToModuleStart(String name, File file) throws ModuleException {
        if (checkModule(name)) {
            try {
                Path newPath = Files.move(file.toPath(), Paths.get(new URI(name + "/" + file.getName())));
                persist.addDocumentToStartModule(newPath.toUri().getPath(), name);
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(ModulesManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new ModuleException("An error ocurred while saving the file");
            }
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    /**
     * Adds a file to the development phase of the selected module
     *
     * @param name the name of the module selected
     * @param file the file to be uploaded to he development phase
     * @throws ModuleException if the module doesn't exists or there is an error
     * while saving the file
     */
    public void addFileToModulDevelopment(String name, File file) throws ModuleException {
        if (checkModule(name)) {
            try {
                Path newPath = Files.move(file.toPath(), Paths.get(new URI(name + "/" + file.getName())));
                persist.addDocumentToDevelopmentModule(newPath.toUri().getPath(), name);
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(ModulesManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new ModuleException("An error ocurred while saving the file");
            }
        } else {
            throw new ModuleException("The module doesn't exists");
        }
    }

    /**
     * Adds a remark to the selected module
     *
     * @param name the name of the module selected
     * @param remark the remark to be added
     * @throws ModuleException if the module doesn't exists
     */
    public void addRemarkToModule(String name, String remark) throws ModuleException {
        persist.addRemarkToModule(remark, name);
    }

    /**
     * Adds a module as a submodule of the development phase of the selected
     * module
     *
     * @param name the name of the selected module
     * @param subModule the module to be added as a submodule
     * @throws ModuleException if the module doesn't exists
     */
    public void addSubModuleToModule(String name, Module subModule) throws ModuleException {
        persist.addSubModuleToModule(subModule, name);
    }

    /**
     * Returns the main modules, those who aren't submodules of other modules
     *
     * @return the main modules, those who aren't submodules of other modules
     */
    public Map<String, Module> getMainModules() {
        return persist.getMainModules();
    }

    /**
     * Returns all the modules which have user as its owner
     *
     * @param userName the name of the user who owns the modules
     * @return all the modules which have user as its owner
     * @throws UserException if the user isn't registered
     */
    public Map<String, Module> getModulesByUser(String userName) throws UserException {
        return persist.getModulesByUser(userName);
    }

    /**
     * Returns all the the main modules, those which aren't submodules of other
     * modules which have user as its owner
     *
     * @param userName the name of the user who owns the modules
     * @return all the the main modules, those which aren't submodules of other
     * modules which have user as its owner
     * @throws UserException if the user isn't registered
     */
    public Map<String, Module> getMainModulesByUser(String userName) throws UserException {
        return persist.getMainModulesByUser(userName);
    }

}
