package userService;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monitor.dao.IUserDao;
import com.monitor.pojos.User;
import com.monitor.service.IUserService;
import com.monitor.serviceimpl.UserServiceImpl;
/**
 * 
 * @author liushahe
 *
 */
@Configuration( "classpath:spring-mvc.xml")
public class UserServiceTest {
	@Autowired
	private IUserDao userDao;
	@Autowired
   private IUserService userService;

	@Before
    public void before(){
         //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
	         //ApplicationContext ac = new ClassPathXmlApplicationContext("spring-db.xml");
	         //从Spring容器中根据bean的id取出我们要使用的userService对象
	         //userService = (IUserService) ac.getBean("sqlSessionFactory");
             System.out.println("aa");
	     }
	@Test
	public void getUser(){
		System.out.println(userService);
		
		User u=userService.getUserById("1");
		System.out.println(u.getUserName());
		
	}

}
