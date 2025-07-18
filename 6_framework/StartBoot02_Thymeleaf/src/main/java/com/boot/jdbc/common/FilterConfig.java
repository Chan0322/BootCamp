package com.boot.jdbc.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정 클래스로 생성하겠다.
@Configuration
public class FilterConfig {
	
	//얘가 리턴해주는 객체를 스프링 bean으로 등록한다.
	@Bean
	public FilterRegistrationBean<Filter> checkFilter(){
		
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>();
		
		// 내부에 만들기 싫으면 외부에 클래스로 만들고, 호출하면 된다.
		
		registrationBean.setFilter(new Filter() {

			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				System.out.println("🚀필터 실행!");
				chain.doFilter(request, response);
			}});
		
		registrationBean.addUrlPatterns("/myboard/*"); //필터를 적용할 경로
		
		return registrationBean;
	}
}
