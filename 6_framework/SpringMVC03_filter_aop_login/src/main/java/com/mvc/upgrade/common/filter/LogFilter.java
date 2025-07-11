package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터 객체 초기화시 실행
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 해당 필터의 처리 결과를 다음 처리로 넘겨주는 역할.
		// 다음 필터가 있으면 다음 필터로, 없으면 서블릿으로...
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = "remoteAddr: " + req.getRemoteAddr() + "\n";	// ip주소
		String uri = "uri: " + req.getRequestURI() + "\n";
		String url = "url: " + req.getRequestURL() + "\n";
		String queryString = "queryString: " + req.getQueryString() + "\n";
		String referer = "referer: " + req.getHeader("referer") + "\n";
		String agent = "agent: " + req.getHeader("User-Agent") + "\n";
		
		logger.info("\nLOG FILTER\n"+remoteAddr+uri+url+queryString+referer+agent);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		//필터 객체 종료시 실행
	}
	
}
