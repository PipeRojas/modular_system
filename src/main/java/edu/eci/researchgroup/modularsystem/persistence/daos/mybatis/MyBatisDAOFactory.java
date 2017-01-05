/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis;

import edu.eci.researchgroup.modularsystem.persistence.daos.DAOFactory;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOModules;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOUser;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Julian David Devia Serna
 */
public class MyBatisDAOFactory extends DAOFactory {

    private static SqlSessionFactory sqlSessionFabrica;
    private SqlSession sesion;

    public static SqlSessionFactory getSqlSessionFactory(String config) {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(config);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory;
    }

    public MyBatisDAOFactory(String properties) {
        sqlSessionFabrica = getSqlSessionFactory(properties);
    }

    @Override
    public void beginSession() {
        sesion = sqlSessionFabrica.openSession();
    }

    @Override
    public void commitTransaction() {
        sesion.commit();
    }

    @Override
    public void rollbackTransaction() {
        sesion.rollback();
    }

    @Override
    public void endSession() {
        sesion.close();
    }

    @Override
    public DAOUser getDAOUser() {
        return new MyBatisDAOUser(sesion);
    }

    @Override
    public DAOModules getDAOModules() {
        return new MyBatisDAOModule(sesion);
    }

}
