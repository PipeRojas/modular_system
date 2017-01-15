/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.services;

import edu.eci.researchgroup.modularsystem.model.Account;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.persistence.AccountsPersistence;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Julian David Devia Serna
 */
public class SecurityManager {
    @Autowired
    private AccountsPersistence pers;
    
    /**
     * Registers an account
     *
     * @param account the account to be registered
     * @throws ModuleException if the account is already registered
     */
    public void registerAccount(Account account) throws ModuleException{
        pers.registerAccount(account);
    }
    
}
