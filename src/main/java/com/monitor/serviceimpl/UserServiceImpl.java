package com.monitor.serviceimpl;

import org.springframework.stereotype.Service;

import com.monitor.dao.IUserDao;
import com.monitor.pojos.User;
import com.monitor.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	 
	private IUserDao userDao;  
	 
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}



}
