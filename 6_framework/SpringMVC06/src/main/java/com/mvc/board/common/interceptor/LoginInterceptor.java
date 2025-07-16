package com.mvc.board.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		if(request.getRequestURI().contains("/loginform.do") ||
			request.getRequestURI().contains("/ajlogin.do") ||
			request.getSession().getAttribute("login")!=null ||
			request.getRequestURI().contains("registerform.do") ||
			request.getRequestURI().contains("register.do")		) {
				return true;
		}
		
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		
		return false;
	}
}
