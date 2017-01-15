/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.controller;

import edu.eci.researchgroup.modularsystem.model.Account;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import edu.eci.researchgroup.modularsystem.services.SecurityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Julian David Devia Serna
 */
@RestController
public class SecurityController {
    
    @Autowired
    private SecurityManager sman;
    
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout(Principal user) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="/app/user", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Account user) {
        try {
            sman.registerAccount(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            return new ResponseEntity<>(ex,HttpStatus.NOT_ACCEPTABLE);
        }
        
    }
}
