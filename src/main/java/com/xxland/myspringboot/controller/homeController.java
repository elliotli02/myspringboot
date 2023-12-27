package com.xxland.myspringboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxland.myspringboot.MyspringbootConfig;
import com.xxland.myspringboot.domain.entity.User;
import com.xxland.myspringboot.domain.mapper.UserMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class homeController {
	private static Logger logger = LogManager.getLogger(homeController.class);
	
	@Autowired
	MyspringbootConfig myspringbootConfig;
	
	@Autowired
	UserMapper userMapper;
	
    @GetMapping("/")
    public String home() {
        return "myhome";
    }

//    @RequestMapping("/init")
//    @ResponseBody
//    public Map<String, String> init() {
//    	
//    	logger.info("12");
//    	
//        Map<String, String> map = new HashMap<>();
//        map.put("message", "Hello World!");
//        return map;
//    }
    
    @RequestMapping("/asu")
	public String init() {
	  	
		logger.info("signin_init");
			  	
//		Map<String, String> map = new HashMap<>();
//		map.put("message", "Hello World!");
		return "login/sign_in";
    }
    
    @RequestMapping("/signin")
    public String sign_in(String userEmail,String userPassword,HttpServletRequest request,Model model) {
    	User user = userMapper.selectUserBySignIn(userEmail,userPassword);
    	
    	if (user == null) {
    		
    		model.addAttribute("email",userEmail);
    		return "login/sign_in";
    	}else {
    		request.getSession().setAttribute("user", user);
    		return "myhome";
    	}
    	
//    	model.addAttribute("testst", "456");
//        return "home";
    }
    
    @RequestMapping("/signout")
    public String sign_out(HttpServletRequest request) {

    	request.getSession().removeAttribute("account");

//    	model.addAttribute("testst", "456");
        return "/";
    }
    
    @RequestMapping("/signup_init")
    public String sign_up_init(Model model) {
    	
    	model.addAttribute("testst", "456");
    	System.out.print(myspringbootConfig.getName());
        return "login/sign_up";
    }
    
}