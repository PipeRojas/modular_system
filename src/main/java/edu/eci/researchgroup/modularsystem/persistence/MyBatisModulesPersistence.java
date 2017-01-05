/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence;

import edu.eci.researchgroup.modularsystem.model.Module;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOFactory;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOModules;
import java.io.IOException;
import java.io.InputStream;
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
public class MyBatisModulesPersistence implements ModulesPersistence {

    private DAOFactory daoF;
    private DAOModules daoM;

    public MyBatisModulesPersistence() {
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
    public boolean checkModule(String name) {
        boolean exists;
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.load(name);
            exists = true;
        } catch (ModuleException ex) {
            exists = false;
        }
        daoF.commitTransaction();
        daoF.endSession();
        return exists;
    }

    @Override
    public void addModule(Module mod) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.save(mod);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

    @Override
    public Map<String, Module> getModules() {
        Map<String,Module> all;
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        all=daoM.loadAll();
        daoF.commitTransaction();
        daoF.endSession();
        return all;
    }

    @Override
    public Module getModule(String name) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        Module mod;
        try {
            mod=daoM.load(name);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
        return mod;
    }

    @Override
    public void updateModule(String oldName, Module mod) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.update(oldName, mod);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

    @Override
    public void addDocumentToStartModule(String uri, String name) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.addDocumentStart(name, uri);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

    @Override
    public void addDocumentToDevelopmentModule(String uri, String name) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.addDocumentDev(name, uri);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

    @Override
    public void addRemarkToModule(String remark, String name) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.addRemark(name, remark);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

    @Override
    public void addSubModuleToModule(Module subModule, String name) throws ModuleException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        try {
            daoM.addSubModule(subModule, name);
            daoF.commitTransaction();
        } catch (ModuleException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
    }

    @Override
    public Map<String, Module> getMainModules() {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        Map<String,Module> main;
        main= daoM.loadMain();
        daoF.commitTransaction();
        daoF.endSession();
        return main;
    }

    @Override
    public Map<String, Module> getModulesByUser(String userName) throws UserException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        Map<String,Module> user;
        try {
            user=daoM.loadByUser(userName);
            daoF.commitTransaction();
        } catch (UserException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
        return user;
    }

    @Override
    public Map<String, Module> getMainModulesByUser(String userName) throws UserException {
        daoF.beginSession();
        daoM = daoF.getDAOModules();
        Map<String,Module> user;
        try {
            user= daoM.loadMainByUser(userName);
            daoF.commitTransaction();
        } catch (UserException ex) {
            throw ex;
        } finally {
            daoF.endSession();
        }
        return user;
    }

}
