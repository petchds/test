package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.User;
import com.tti.accscms.domain.movement.UserExample;
import com.tti.accscms.domain.movement.Role;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table user
 */
public interface UserDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(User user) throws DaoException;

    public User findById(Integer id) throws DaoException;
	
    public List<User> findAllByRole(Role role) throws DaoException;

	public int update(User user) throws DaoException;
	
	public int countByUserExample(UserExample userExample) throws DaoException;
	
	public User findByUserExample(UserExample userExample) throws DaoException;
	
    public List<User> findAllByUserExample(UserExample userExample) throws DaoException;
    
    public List<User> findAllByUserExample(UserExample userExample, int limit) throws DaoException;
    
    public List<User> findAllByUserExample(UserExample userExample, int offset, int limit) throws DaoException;
}
