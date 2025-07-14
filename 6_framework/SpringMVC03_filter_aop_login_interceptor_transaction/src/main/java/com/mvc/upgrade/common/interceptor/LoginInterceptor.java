package com.mvc.upgrade.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	// Controller 실행 전 수행되는 메서드
	// 요청을 가로채 처리 중단 가능하다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("[interceptor] preHandle");
		
		if(request.getRequestURI().contains("/loginform.do") || request.getRequestURI().contains("/ajaxlogin.do") || request.getSession().getAttribute("login")!=null || request.getRequestURI().contains("/test.do")) {
			return true;
		}
		// return 값이 true : controller 실행
		//			 false : controller 실행 시키지 않고 요청 종료
		
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		
		return false;
	}
	
	// Controller 실행 후, view 렌더링 전 수행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		logger.info("[interceptor] postHandle");
	}
	
	// view 렌더링 완료 후 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("[interceptor] afterCompletion");
	}
}
