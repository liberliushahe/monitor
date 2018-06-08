package com.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monitor.pojos.User;
import com.monitor.service.IUserService;
/**
 * 
 * @author liushahe
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userServiceImpl;
	@RequestMapping(value = "/id", method = RequestMethod.GET)
    public String getUserList(Model model){
		
        User user = userServiceImpl.getUserById("u20180602104804751956");      
        System.out.println(user.getUserName());
        return "user";
    }
	

}
