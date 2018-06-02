package com.monitor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.dao.IUserDao;
import com.monitor.pojos.User;
import com.monitor.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {
	 @Autowired
	private IUserDao userDao;  
	 
	@Override
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}



}
