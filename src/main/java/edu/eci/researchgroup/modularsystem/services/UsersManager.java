/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.services;

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.persistence.UsersPersistence;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian David Devia Serna
 */
@Service
public class UsersManager {

    /**
     * Returns the persistence component of the manager
     *
     * @return the persist
     */
    public UsersPersistence getPersist() {
        return persist;
    }

    /**
     * Sets a persistence component to the manager
     *
     * @param persist the persist to set
     */
    public void setPersist(UsersPersistence persist) {
        this.persist = persist;
    }

    @Autowired
    private UsersPersistence persist;

    /**
     * Checks if the user with the given name is registered or not
     *
     * @param name the name of the user to check
     * @return true if the user exists or not, false otherwise
     */
    public boolean checkUser(String name) {
        return persist.checkUser(name);
    }

    /**
     * Registers an user
     *
     * @param user the user to add
     * @throws UserException if the user already exists
     */
    public void addUser(User user) throws UserException {
        persist.addUser(user);
    }

    /**
     * Returns the user with the given name
     *
     * @param name the name of the wanted user
     * @return the requested user
     * @throws UserException if the user doesn't exists
     */
    public User getUser(String name) throws UserException {
        return persist.getUser(name);
    }

    /**
     * Returns all the registered users
     *
     * @return all the registered users
     */
    public Map<String, User> getUsers() {
        return persist.getUsers();
    }

    /**
     * Updates an user given its name before the changes and all the new
     * information
     *
     * @param oldName the old name of the user to update
     * @param user the current user
     * @throws UserException if the oldName is not registered or the new name of
     * the user already exists
     */
    public void updateUser(String oldName, User user) throws UserException {
        persist.updateUser(oldName, user);
    }
}
