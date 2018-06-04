package com.monitor.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.monitor.pojos.User;
/**
 * 
 * @author liushahe
 * {@docRoot}
 */
@MapperScan
public interface IUserDao {
	/**
	 * {@docRoot}
	 * @param id
	 * @return
	 * 
	 */
	public User getUserById(String id);

}
