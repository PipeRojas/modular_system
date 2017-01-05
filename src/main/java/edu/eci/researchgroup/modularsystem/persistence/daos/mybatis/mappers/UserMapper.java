/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers;

import edu.eci.researchgroup.modularsystem.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Julian David Devia Serna
 */
public interface UserMapper {

    /**
     * Loads an user given its name
     *
     * @param name the name of the selected user
     * @return the user with the given name
     */
    public User load(@Param("name") String name);

    /**
     * Loads all the registered users
     *
     * @return all the registered users
     */
    public List<User> loadAll();

    /**
     * Registers an user into the DB
     *
     * @param user the user to save
     */
    public void save(@Param("user") User user);

    /**
     * Updates an user given its oldName and all the new information
     *
     * @param oldName the name of the user to update before the changes
     * @param user the user with all the new information
     */
    public void update(@Param("oldName") String oldName, @Param("user") User user);
}
