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
     *
     * @param name the name of the user to check
     * @return true if the user exists or not, false otherwise
     */
    public boolean checkUser(String name);
    
    /**
     *
     * @param user the user to add
     * @throws UserException if the user already exists
     */
    public void addUser(User user) throws UserException;
    
    /**
     *
     * @param name the name of the wanted user
     * @return the requested user
     * @throws UserException if the user doesn't exists
     */
    public User getUser(String name) throws UserException;
    
    /**
     *
     * @return all the registered users
     */
    public Map<String,User> getUsers();
    
    /**
     *
     * @param oldName the old name of the user to update
     * @param user the current user
     * @throws UserException if the oldName is not registered or the new name of the user already exists
     */
    public void updateUser(String oldName,User user) throws UserException;
}
