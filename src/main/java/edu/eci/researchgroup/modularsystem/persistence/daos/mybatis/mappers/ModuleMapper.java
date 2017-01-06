/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers;

import edu.eci.researchgroup.modularsystem.model.Module;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Julian David Devia Serna
 */
public interface ModuleMapper {

    /**
     * Loads the module with the given name
     *
     * @param name the name of the selected module
     * @return the module with the given name
     */
    public Module load(@Param("name") String name);

    /**
     * Loads all the submodules of the module with the given name
     *
     * @param name the name of the selected module
     * @return all the submodules of the module with the given name
     */
    public List<Module> loadSubMod(@Param("name") String name);

    /**
     * Loads all the registered modules
     *
     * @return all the registered modules
     */
    public List<Module> loadAll();

    /**
     * Loads all the main modules, those which aren't submodules of any module
     *
     * @return all the main modules, those which aren't submodules of any module
     */
    public List<Module> loadMain();

    /**
     * Loads all the modules which have the given user as its owner
     *
     * @param userName the name of the owner of the modules
     * @return all the modules which have the given user as its owner
     */
    public List<Module> loadByUser(@Param("userName") String userName);

    /**
     * Loads all the main modules which have the given user as its owner
     *
     * @param userName the name of the owner of the modules
     * @return all the main modules which have the given user as its owner
     */
    public List<Module> loadMainByUser(@Param("userName") String userName);

    /**
     * Registers a module
     *
     * @param module the module to be registered
     */
    public void insertModule(@Param("module") Module module);

    /**
     * Registers a module as a submodule of another module
     *
     * @param nameMod the module which will have the submodule
     * @param nameSubMod the submodule
     */
    public void insertSubModule(@Param("nameMod") String nameMod, @Param("nameSubMod") String nameSubMod);

    /**
     * Registers a document as part of the start phase of the module
     *
     * @param name the name of the module
     * @param uri the uri of the document
     */
    public void insertDocStart(@Param("name") String name, @Param("uri") String uri);

    /**
     * Registers a document as part of the development phase of the module
     *
     * @param name the name of the module
     * @param uri the uri of the document
     */
    public void insertDocDev(@Param("name") String name, @Param("uri") String uri);

    /**
     * Registers a remark as part of the module
     *
     * @param name the name of the module
     * @param remark the remark
     */
    public void insertRemark(@Param("name") String name, @Param("remark") String remark);

    /**
     * Updates a module given its name before the changes and the new
     * information
     *
     * @param oldName the name of the module before the changes
     * @param mod the module with all the new information
     */
    public void updateModule(@Param("oldName") String oldName, @Param("mod") Module mod);

    /**
     * Deletes a document from the start phase of a module
     *
     * @param name the name of the module
     * @param uri the uri of the document to remove
     */
    public void deleteStartDoc(@Param("name") String name, @Param("uri") String uri);

    /**
     * Deletes a document from the development phase of a module
     *
     * @param name the name of the module
     * @param uri the uri of the document to remove
     */
    public void deleteDevDoc(@Param("name") String name, @Param("uri") String uri);

    /**
     * Deletes a submodule from the development phase of a module
     *
     * @param modName the name of the module
     * @param subModName the name of the submodule
     */
    public void deleteSubMod(@Param("modName") String modName, @Param("subModName") String subModName);

    /**
     * Deletes a remark of a module
     *
     * @param name the name of the module
     * @param remark the remark
     */
    public void deleteRemark(@Param("name") String name, @Param("remark") String remark);

}
