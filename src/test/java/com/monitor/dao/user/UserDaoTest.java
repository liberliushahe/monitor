package com.monitor.dao.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.monitor.dao.IUserDao;
import com.monitor.pojos.User;
/**
 * 
 * @author liushahe
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-db.xml")
public class UserDaoTest {
	@Autowired
	private IUserDao iUserDao;
	@Test
	public void getUser(){
		System.out.println(iUserDao);
		User u=iUserDao.getUserById("u20180602104804751956");
		System.out.println(u.getUserName());
		
	}

}
