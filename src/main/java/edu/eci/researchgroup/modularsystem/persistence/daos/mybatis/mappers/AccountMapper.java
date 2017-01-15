/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers;

import edu.eci.researchgroup.modularsystem.model.Account;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Julian David Devia Serna
 */
public interface AccountMapper {

    /**
     * Inserts an account into de database
     *
     * @param account the account to insert
     */
    public void insertAccount(@Param("account") Account account);

    /**
     * Queries the account given its username
     *
     * @param username the username of the selected account
     * @return the selected account
     */
    public Account selectAccount(@Param("username") String username);
}
