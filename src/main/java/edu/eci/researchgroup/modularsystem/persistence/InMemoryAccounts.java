/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.Account;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian David Devia Serna
 */
public class InMemoryAccounts implements AccountsPersistence {

    private Map<String, Account> accounts;

    public InMemoryAccounts() {
        accounts = new HashMap<>();
        staticAccounts(this);
    }

    @Override
    public void registerAccount(Account account) throws ModuleException {
        if (!accounts.containsKey(account.getUsername())) {
            accounts.put(account.getUsername(), account);
        } else {
            throw new ModuleException("The account is already registered");
        }
    }

    public static void staticAccounts(InMemoryAccounts pers) {
        try {
            Account ac1 = new Account();
            ac1.setUsername("user");
            ac1.setPassword("$2a$06$w77UIn0kmK3YMhJFtl84SeLbK07qJWuPFHbHP2WhJy796O09mlwlO");

            Account ac2 = new Account();
            ac2.setUsername("user2");
            ac2.setPassword("$2a$06$RztaXi9.vUU6sjKlB7wGIui9s6d82Tx5o0.MvMlPcPNytlu2jljk2");

            Account ac3 = new Account();
            ac3.setUsername("user11");
            ac3.setPassword("$2a$06$hkZXZDjLgi750fjOfqUXx.Mynr0p/C2tCTf3KekQQpnGDU/fCdauG");

            Account ac4 = new Account();
            ac4.setUsername("user12");
            ac4.setPassword("$2a$06$ztA4iBgi/.klgXz2a.i5FuWQ4F9T9sTOfWmKSVzq8v5namhh/co3a");

            pers.registerAccount(ac1);
            pers.registerAccount(ac2);
            pers.registerAccount(ac3);
            pers.registerAccount(ac4);
        } catch (ModuleException ex) {
            Logger.getLogger(InMemoryAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
