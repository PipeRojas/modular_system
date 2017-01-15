/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis;

import edu.eci.researchgroup.modularsystem.model.Account;
import edu.eci.researchgroup.modularsystem.model.ModuleException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOAccount;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.AccountMapper;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.ModuleMapper;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.RoleMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Julian David Devia Serna
 */
public class MyBatisDAOAccount implements DAOAccount{
    
    private SqlSession ses;
    private AccountMapper amap;
    private RoleMapper rmap;
    
    public MyBatisDAOAccount(SqlSession ses) {
        this.ses = ses;
        amap = ses.getMapper(AccountMapper.class);
        rmap = ses.getMapper(RoleMapper.class);
    }

    @Override
    public void insertAccount(Account account) throws ModuleException{
        if(amap.selectAccount(account.getUsername())==null){
            amap.insertAccount(account);
            rmap.insertRole(account.getUsername(), "ROLE_USER");
        }else{
            throw new ModuleException("The account is already registered");
        }
    }
    
}
