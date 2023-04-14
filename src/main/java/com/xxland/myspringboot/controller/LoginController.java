package com.xxland.myspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	private static Logger logger = LogManager.getLogger(LoginController.class);
	
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login_init")
    @ResponseBody
    public Map<String, String> init() {
    	
    	logger.info("12");
    	
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World!");
        return map;
    }
}