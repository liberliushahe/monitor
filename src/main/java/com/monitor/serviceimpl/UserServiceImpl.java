package com.monitor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.dao.IUserDao;
import com.monitor.pojos.User;
import com.monitor.service.IUserService;
/**
 * 
 * @author liushahe
 * 
 */
@Service
public class UserServiceImpl implements IUserService {
	 @Autowired
	private IUserDao iUserDao;  
	 
	@Override
	public User getUserById(String userId) {
		return iUserDao.getUserById(userId);
	}



}
