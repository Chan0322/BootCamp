package com.mvc.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.rest.model.dto.RestDto;
import com.mvc.rest.model.service.RestService;

@RestController
public class RestControllerTest {
// RESTfull 방식의 요청을 받아서 처리.
	
	@Autowired
	private RestService service;
	
	@RequestMapping(value="/restdto", method=RequestMethod.GET)
	public List<RestDto> getRest() {
		System.out.println("selectList");
		List<RestDto> list = service.selectList();
		
		return list;
	}
	
	@RequestMapping(value="restdto/{restno}", method=RequestMethod.GET)
	public RestDto getRestOne(@PathVariable int restno) {
		System.out.println("selectOne: " + restno);
		RestDto res = service.selectOne(restno);
		
		return res;
	}
	
	@RequestMapping(value="restdto", method=RequestMethod.POST)
	public Map<String, Integer> postRest(RestDto dto) {
		
		int res = service.insert(dto);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(res>0) {
			map.put("code", 200);
		}else {
			map.put("code",	500);
		}
		return map;
	}
	
	@RequestMapping(value="restdto/{restno}", method=RequestMethod.DELETE)
	public Map<String, Integer> deleteRest(@PathVariable int restno) {
		System.out.println("delete method : " + restno);
		
		int res = service.delete(restno);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(res>0) {
			map.put("code", 200);
		}else {
			map.put("code", 500);
		}
		return map;
	}
	
	/*
	@RequestMapping(value="restdto/{restno}", method=RequestMethod.PUT)
	public Map<String, Integer> putRest(@PathVariable int restno, String restpw) {
		RestDto dto = new RestDto();
		dto.setRestno(restno);
		dto.setRestpw(restpw);
		int res = service.update(dto);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(res>0) {
			map.put("code", 200);
		}else {
			map.put("code", 500);
		}
		return map;
	}
	*/
	@RequestMapping(value="/restdto", method=RequestMethod.PUT)
	public Map<String, Integer> putRest(RestDto dto) {
		System.out.println("put : " + dto.getRestno()+", "+dto.getRestpw());
		int res = service.update(dto);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(res>0) {
			map.put("code", 200);	// 성공
		}else {
			map.put("code", 500);	// 실패
		}
		return map;
	}
}
