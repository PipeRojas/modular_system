/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.Account;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOAccount;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian David Devia Serna
 */
@Service
public class MyBatisAccountPersistence implements AccountsPersistence{
    
    private DAOFactory daoF;
    private DAOAccount daoA;
    
    public MyBatisAccountPersistence(){
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
    public void registerAccount(Account account) throws ModuleException {
        daoF.beginSession();
        daoA = daoF.getDAOAccount();
        try {
            daoA.insertAccount(account);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            daoF.rollbackTransaction();
            throw ex;
        } finally {
            daoF.endSession();
        }
    }
    
}
