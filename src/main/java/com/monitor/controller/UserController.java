package com.monitor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private IUserService userService;
	@RequestMapping("/id")
    public String getUserList(HttpServletRequest request,Model model){
		String id=request.getParameter("id");
        User user = userService.getUserById(id);      
        System.out.println(user);
        return "view/admin/user";
    }
	

}
