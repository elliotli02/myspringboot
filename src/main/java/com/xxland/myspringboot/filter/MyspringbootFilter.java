package com.xxland.myspringboot.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@WebFilter(urlPatterns="/*")
public class MyspringbootFilter implements Filter{

	private final String[] IGNORE_URI = {"index","/xxland/","/xxland/css/","/xxland/signup_init","/xxland/images/","/xxland/js/","/xxland/libs/","/xxland/login/signin_init","/xxland/login/signin","/xxland/login/signup"};
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO 自動生成されたメソッド・スタブ
//		System.out.println("---Filter---" );
	
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String uri= request.getRequestURI();
		
		boolean pass = canPassIgnore(uri);
		System.out.println("---Filter---" + pass);
		if(pass) {
			System.out.println("---Filter---" + uri);
			chain.doFilter(req, res);
			return;
		}
		
		Object object = request.getSession().getAttribute("account");
		
		if(null == object) {
			System.out.println("---Filter---" + uri);
//			response.sendRedirect("/xxland/login/signin_init");
			chain.doFilter(req, res);
			return;
		}
		System.out.println("---Filter---" + uri);
		
//		System.out.println("---Filter---");
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------MyspringbootFilter Init------------------");
		Filter.super.init(filterConfig);
	}
	private boolean canPassIgnore(String uri) {
		for(String val : IGNORE_URI) {
			if(uri.startsWith(val)) {
				return true;
			};
			
		}
		return false;
	}
	
}
