package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.dao.BikeDao;
import com.test.dto.BikeDto;

@WebServlet("/bike.do")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
			
		}else if(command.equals("second")) {
			response.sendRedirect("bike02.jsp");
			
		}else if(command.equals("second_db")) {
			new BikeDao().deleteAll();
			
			String obj = request.getParameter("obj");
			//System.out.println(obj);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(obj);
			
			//DATA의 첫 번째 방에 저장된 json 데이터 new_addr 값 저장하기.
//			String str = element.getAsJsonObject().get("DATA").getAsJsonArray().get(0).getAsJsonObject().get("new_addr").getAsString();
//			System.out.println(str);
//			
//			// DESCRIPTION이 가지는 data의 ADDR_GU 의 값을 String 으로 저장하기.
//			str = element.getAsJsonObject().get("DESCRIPTION").getAsJsonObject().get("ADDR_GU").getAsString();
//			System.out.println(str);
			
			List<BikeDto> list = new ArrayList<>();
			
			for(int i=0; i<element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i++) {
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
//				System.out.println(tmp.get("new_addr").getAsString());
				String addr_gu = tmp.get("addr_gu").getAsString();
				int content_id = tmp.get("content_id").getAsInt();
				String content_nm = tmp.get("content_nm").getAsString();
				String new_addr = tmp.get("new_addr").getAsString();
				int cradle_count = tmp.get("cradle_count").getAsInt();
				double longitude = tmp.get("longitude").getAsDouble();
				double latitude = tmp.get("latitude").getAsDouble();
				
				BikeDto dto = new BikeDto();
				dto.setAddr_gu(addr_gu);
				dto.setContent_id(content_id);
				dto.setContent_nm(content_nm);
				dto.setNew_addr(new_addr);
				dto.setCradle_count(cradle_count);
				dto.setLongitude(longitude);
				dto.setLatitude(latitude);
				
				list.add(dto);
			}
			
			int res = new BikeDao().insert(list);
			if(res == list.size()) {
				System.out.println("insert 성공\n");
			}else {
				System.out.println("insert 실패\n");
			}
			PrintWriter out = response.getWriter();
			out.println(res);
			
			
		}else if(command.equals("first_db")) {
//			System.out.println(request.getParameter("bike"));	// 동일한 이름의 파라미터 값은 1개만 받을 수 있음.
			String[] bikeList = request.getParameterValues("bike");
			System.out.println("bikelist의 크기: " + bikeList.length);	// 파라미터 값으로 받을 수 있는 최대 갯수는 999
			
			List<BikeDto> list = new ArrayList<>();
			for(int i=0; i<bikeList.length; i++) {
				//강남구/2301/ 현대고등학교 건너편/서울특별시 강남구 압구정로 134/10/127.02179/37.524071
				String[] tmp = bikeList[i].split("/");
				BikeDto dto = new BikeDto();
				dto.setAddr_gu(tmp[0]);
				dto.setContent_id(Integer.parseInt(tmp[1]));
				dto.setContent_nm(tmp[2]);
				dto.setNew_addr(tmp[3]);
				dto.setCradle_count(Integer.parseInt(tmp[4]));
				dto.setLongitude(Double.parseDouble(tmp[5]));
				dto.setLatitude(Double.parseDouble(tmp[6]));
				
				list.add(dto);
			}
			new BikeDao().deleteAll();
			int res = new BikeDao().insert(list);
			if(res>0) {
				System.out.println("insert 성공\n");
				response.sendRedirect("index.html");
			}else {
				System.out.println("insert 실패\n");
				response.sendRedirect("bike01.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
