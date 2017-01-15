/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos;

import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.MyBatisDAOFactory;
import java.util.Properties;

/**
 *
 * @author Julian David Devia Serna
 */
public abstract class DAOFactory {

    private static DAOFactory instance = null;

    /**
     * Returns an instance of DAOFactory
     *
     * @param appProperties the properties of the instance
     * @return the properties specified DAOFactory
     */
    public static DAOFactory getInstance(Properties appProperties) {
        if (instance == null) {
            synchronized (DAOFactory.class) {
                if (instance == null) {
                    if (appProperties.get("dao").equals("mybatis")) {
                        instance = new MyBatisDAOFactory(appProperties.getProperty("config"));
                    } else {
                        throw new RuntimeException("Wrong configuration: Unsupported DAO:" + appProperties.get("dao"));
                    }
                }
            }
        }
        return instance;
    }

    /**
     * Begins a new session
     */
    public abstract void beginSession();

    /**
     * Commits a transaction
     */
    public abstract void commitTransaction();

    /**
     * Rollbacks a transaction
     */
    public abstract void rollbackTransaction();

    /**
     * Ends the current session
     */
    public abstract void endSession();

    /**
     * Returns a DAOUser
     *
     * @return Returns a DAOUser
     */
    public abstract DAOUser getDAOUser();

    /**
     * Returns a DAOModules
     *
     * @return Returns a DAOModules
     */
    public abstract DAOModules getDAOModules();
    
    /**
     * Returns a DAOAccount
     * @return Returns a DAOAccount
     */
    public abstract DAOAccount getDAOAccount();
}
