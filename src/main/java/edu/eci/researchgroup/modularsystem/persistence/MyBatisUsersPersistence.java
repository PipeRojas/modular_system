/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOFactory;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOUser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian David Devia Serna
 */
@Service
public class MyBatisUsersPersistence implements UsersPersistence {

    private DAOFactory daoF;
    private DAOUser daoU;

    public MyBatisUsersPersistence() {
        try {
            InputStream input = getClass().getClassLoader().getResource("applicationconfig.properties").openStream();
            Properties properties = new Properties();
            properties.load(input);
            daoF = DAOFactory.getInstance(properties);
        } catch (IOException ex) {
            Logger.getLogger(MyBatisUsersPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean checkUser(String name) {
        boolean exists;
        daoF.beginSession();
        daoU = daoF.getDAOUser();
        try {
            daoU.load(name);
            exists = true;
        } catch (UserException ex) {
            exists = false;
        }
        daoF.commitTransaction();
        daoF.endSession();
        return exists;
    }

    @Override
    public void addUser(User user) throws UserException {
        daoF.beginSession();
        daoU = daoF.getDAOUser();
        try {
            daoU.save(user);
            daoF.commitTransaction();
        } catch (UserException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }

    }

    @Override
    public User getUser(String name) throws UserException {
        User user;
        daoF.beginSession();
        daoU = daoF.getDAOUser();
        try {
            user = daoU.load(name);
            daoF.commitTransaction();
        } catch (UserException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
        if (user == null) {
            throw new UserException("The user isn't registered yet");
        }
        return user;
    }

    @Override
    public Map<String, User> getUsers() {
        List<User> users;
        daoF.beginSession();
        daoU = daoF.getDAOUser();
        users = daoU.loadAll();
        daoF.commitTransaction();
        daoF.endSession();
        Map<String, User> allUsers = new HashMap<>();
        for (User user : users) {
            allUsers.put(user.getName(), user);
        }
        return allUsers;
    }

    @Override
    public void updateUser(String oldName, User user) throws UserException {
        daoF.beginSession();
        daoU = daoF.getDAOUser();
        try {
            daoU.update(oldName, user);
            daoF.commitTransaction();
        } catch (UserException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

}
