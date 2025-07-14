package com.mvc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.rest.model.service.RestService;

@RestController
public class RestControllerTest {
// RESTfull 방식의 요청을 받아서 처리.
	
	@Autowired
	private RestService service;
	
	@RequestMapping(value="/restdto", method=RequestMethod.GET)
	public String getRest() {
		System.out.println("selectList");
		return null;
	}
	
	@RequestMapping(value="restdto/{restno}", method=RequestMethod.GET)
	public String getRestOne(@PathVariable int restno) {
		System.out.println("selectOne: " + restno);
		return null;
	}
}
