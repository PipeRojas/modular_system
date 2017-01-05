/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.persistence.daos.mybatis;

import edu.eci.researchgroup.modularsystem.model.User;
import edu.eci.researchgroup.modularsystem.model.UserException;
import edu.eci.researchgroup.modularsystem.persistence.daos.DAOUser;
import edu.eci.researchgroup.modularsystem.persistence.daos.mybatis.mappers.UserMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Julian David Devia Serna
 */
public class MyBatisDAOUser implements DAOUser{
    
    private SqlSession ses;
    private UserMapper umap;
    
    public MyBatisDAOUser(SqlSession ses) {
        this.ses = ses;
        umap = ses.getMapper(UserMapper.class);
    }

    @Override
    public List<User> loadAll() {
        return umap.loadAll();
    }

    @Override
    public User load(String name) throws UserException {
        if(name==null || name.length()==0){
            throw new UserException("The user name must't be null");
        }
        return umap.load(name);
    }

    @Override
    public void save(User user) throws UserException {
        if(user==null){
            throw new UserException("The user name mustn't be null");
        }
        if(load(user.getName())!=null){
            throw new UserException("The user is already registered");
        }
        umap.save(user);
    }

    @Override
    public void update(String oldName, User user) throws UserException {
        if(oldName==null || oldName.length()==0){
            throw new UserException("The old user name mustn't be null");
        }
        if(user==null){
            throw new UserException("The user name mustn't be null");
        }
        if(load(oldName)==null){
            throw new UserException("The user isn't registered yet");
        }
        umap.update(oldName, user);
        
    }
    
}
