/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Julian David Devia Serna
 */
public interface RoleMapper {

    /**
     * Inserts the given username with the given role in the database
     *
     * @param username The username to insert
     * @param role The role to insert
     */
    public void insertRole(@Param("username") String username, @Param("role") String role);

}
