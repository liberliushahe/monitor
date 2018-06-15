package com.monitor.service.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.monitor.pojos.User;
import com.monitor.service.IUserService;
/**
 * 
 * @author liushahe
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-db.xml","/spring-mvc.xml"})
public class UserServiceTest {
    @Autowired
	private IUserService iUserService;
	@Test
	public void getUser(){
		User u=iUserService.getUserById("u20180602104804751956");
		System.out.println(u.getUserName());
		
	}

}
