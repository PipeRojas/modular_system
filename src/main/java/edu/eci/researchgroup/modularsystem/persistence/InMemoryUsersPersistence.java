/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian David Devia Serna
 */
@Service
public class InMemoryUsersPersistence implements UsersPersistence {
    
    private HashMap<String,User> users;
    
    public InMemoryUsersPersistence(){
        users= new HashMap<>();
        InMemoryUsersPersistence.staticUsers(this);
    }
    
    @Override
    public boolean checkUser(String name) {
        return users.containsKey(name);
    }

    @Override
    public void addUser(User user) throws UserException {
        if(!checkUser(user.getName())){
            users.put(user.getName(), user);
        }
        throw new UserException("The user already exists");
    }

    @Override
    public User getUser(String name) throws UserException {
        if(checkUser(name)){
            return users.get(name);
        }
        throw new UserException("The user doesn't exists");
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }

    @Override
    public void updateUser(String oldName, User user) throws UserException {
        if(checkUser(oldName)){
            addUser(user);
            users.remove(oldName);
        }
        throw new UserException("The user doesn't exists");
    }
    
    public static void staticUsers(InMemoryUsersPersistence us){
        User u= new User();
        u.setName("user");
        u.setSelection("a");
        u.setText("b");
        try {
            us.addUser(u);
        } catch (UserException ex) {
            Logger.getLogger(InMemoryUsersPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
