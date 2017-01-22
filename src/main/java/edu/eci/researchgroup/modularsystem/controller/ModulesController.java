/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.controller;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.services.ModulesManager;
import java.io.File;
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

/**
 *
 * @author amoto
 */
@RestController
@RequestMapping(value = "/modules")
public class ModulesController {

    @Autowired
    private ModulesManager mm;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getModules() {
        return new ResponseEntity<>(mm.getModules(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{moduleName}")
    public ResponseEntity<?> getModule(@PathVariable String moduleName) {
        try {
            return new ResponseEntity<>(mm.getModule(moduleName), HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mainModules")
    public ResponseEntity<?> getMainModules() {
        return new ResponseEntity<>(mm.getMainModules(), HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/user/{userName}")
    public ResponseEntity<?> getModulesByUser(@PathVariable String userName) {
        try {
            return new ResponseEntity<>(mm.getModulesByUser(userName), HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(ModulesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/mainModules/{userName}")
    public ResponseEntity<?> getMainModulesByUser(@PathVariable String userName) {
        try {
            return new ResponseEntity<>(mm.getMainModulesByUser(userName), HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(ModulesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postModule(@RequestBody Module m) {
        try {
            mm.addModule(m);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(ModulesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{oldModuleName}")
    public ResponseEntity<?> putModule(@PathVariable String oldModuleName, @RequestBody Module m) {
        try {
            mm.updateModule(oldModuleName, m);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/remark/{moduleName}")
    public ResponseEntity<?> addRemarkModule(@PathVariable String moduleName, @RequestBody String remark) {
        try {
            mm.addRemarkToModule(moduleName, remark);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/startDocument/{moduleName}")
    public ResponseEntity<?> addStarFileModule(@PathVariable String moduleName, @RequestBody File file) {
        try {
            mm.addFileToModuleStart(moduleName, file);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/developmentDocument/{moduleName}")
    public ResponseEntity<?> addDevelopmentFileModule(@PathVariable String moduleName, @RequestBody File file) {
        try {
            mm.addFileToModulDevelopment(moduleName, file);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/subModule/{moduleName}")
    public ResponseEntity<?> addSubModule(@PathVariable String moduleName, @RequestBody Module subModule) {
        try {
            mm.addSubModuleToModule(moduleName, subModule);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ModuleException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
