/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis;

import edu.eci.researchgroup.modularsystem.persistence.daos.DAOModules;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.ModuleMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Julian David Devia Serna
 */
public class MyBatisDAOModule implements DAOModules {

    private SqlSession ses;
    private ModuleMapper mmap;

    public MyBatisDAOModule(SqlSession ses) {
        this.ses = ses;
        mmap = ses.getMapper(ModuleMapper.class);
    }
}
