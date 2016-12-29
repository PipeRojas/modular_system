/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.controller;

/**
 *
 * @author Julian David Devia Serna
 */
 

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.services.UsersManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    
    @Autowired
    private UsersManager um;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(um.getUsers(), HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName) {
        try {
            return new ResponseEntity<>(um.getUser(userName), HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postUser(@RequestBody User u) {
        try {
            um.addUser(u);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{oldUserName}")
    public ResponseEntity<?> postUser(@PathVariable String oldUserName,@RequestBody User u) {
        try {
            um.updateUser(oldUserName,u);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
