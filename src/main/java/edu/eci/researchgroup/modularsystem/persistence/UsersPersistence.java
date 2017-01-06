/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import java.util.Map;

/**
 *
 * @author Julian David Devia Serna
 */
public interface UsersPersistence {

    /**
     * Checks if the user with the given name is registered or not
     *
     * @param name the name of the user to check
     * @return true if the user exists or not, false otherwise
     */
    public boolean checkUser(String name);

    /**
     * Registers an user
     *
     * @param user the user to add
     * @throws UserException if the user already exists
     */
    public void addUser(User user) throws UserException;

    /**
     * Returns the user with the given name
     *
     * @param name the name of the wanted user
     * @return the requested user
     * @throws UserException if the user doesn't exists
     */
    public User getUser(String name) throws UserException;

    /**
     * Returns all the registered users
     *
     * @return all the registered users
     */
    public Map<String, User> getUsers();

    /**
     * Updates an user given its name before the changes and all the new
     * information
     *
     * @param oldName the old name of the user to update
     * @param user the current user
     * @throws UserException if the oldName is not registered or the new name of
     * the user already exists
     */
    public void updateUser(String oldName, User user) throws UserException;
}
