/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos;

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import java.util.List;

/**
 *
 * @author Julian David Devia Serna
 */
public interface DAOUser {

    /**
     * Loads all the registered users
     *
     * @return all the registered users
     */
    public List<User> loadAll();

    /**
     * Loads the specified user
     *
     * @param name the name of the user to load
     * @return the specified user
     * @throws edu.eci.researchgroup.modularsystem.model.UserException if the
     * name is null
     */
    public User load(String name) throws UserException;

    /**
     * Registers the user
     *
     * @param user the user to be registered
     * @throws edu.eci.researchgroup.modularsystem.model.UserException if the
     * user is null or the user already exists
     */
    public void save(User user) throws UserException;

    /**
     * updates an user given its old name and the new information
     *
     * @param oldName the user's name before the changes
     * @param user the current information of the user
     * @throws edu.eci.researchgroup.modularsystem.model.UserException if the
     * user or the oldName is null or the user with oldName is not registered
     */
    public void update(String oldName, User user) throws UserException;
}
