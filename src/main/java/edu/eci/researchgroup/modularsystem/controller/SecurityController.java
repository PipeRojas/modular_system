/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
/**
 *
 * @author Julian David Devia Serna
 */
public class SecurityController {
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout(Principal user) {
        return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
    }
}
