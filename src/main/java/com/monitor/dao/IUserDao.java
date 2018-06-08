package com.monitor.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.monitor.pojos.User;

/**
 * 
 * @author liushahe {@docRoot}
 */
@MapperScan
@Repository
public interface IUserDao {
	/**
	 * {@docRoot}
	 * 
	 * @param id
	 * @return
	 * 
	 */
	public User getUserById(String id);

	/**
	 * {@docRoot}
	 * 
	 * @param user
	 */
	void save(User user);

	/**
	 * {@docRoot}
	 * 
	 * @param user
	 * @return
	 */
	boolean update(User user);

	/**
	 * {@docRoot}
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	/**
	 * {@docRoot}
	 * 
	 * @return
	 */
	List<User> findAll();
}
