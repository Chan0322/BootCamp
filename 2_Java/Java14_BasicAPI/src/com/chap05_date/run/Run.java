package com.chap05_date.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Run {
/*
 * Date : 기준 1970년 1월 1일 0시 0분 0초, ms단위
 * Calendar
 * GregorianCalendar
 * - java.util패키지
 * */
	public static void main(String[] args) {
		Date oriTime = new Date();
		oriTime = new Date(); //70년 1월 1일
		System.out.println(oriTime);
		oriTime = new Date(1000L); //최소 셋팅 값에서 1초 흐른 시간. // 9시라고 나오는 건, 우리나라가 기준 시각보다 9시간 늦어서.
		System.out.println(oriTime);
		System.out.println(oriTime.toGMTString()); //그리니치 표준시 기준.
		
		
		Date toDay = new Date();
		
		//원하는 패턴으로 출력
		//SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss"); // MM - Month   mm - minutes  대소문자 구분!
		System.out.println(sdf.format(toDay));
		
		
		System.out.println("-----------------캘린더-----------------");
		//월은 -1 해서 관리한다.
		//필드넘버 개념 => 필드에 접근할 때, 필드명이 아닌 숫자로도 접근 가능.
		
//		Calendar calendar = new Calendar(); // 캘린더의 접근 제한자는 protected. 같은 패키지 안에서만 사용 가능. 이를 대체해 getInstance 사용.
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		//수정
		calendar.set(2022, 2-1, 22);
		System.out.println(calendar);
		
		
		int year = calendar.get(1);   // 필드별로 저장되어 있고, 넘버로 가져올 수 있다.
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		
		System.out.println(year+"년 "+month+"월 "+date+"일 ");
		
		//SimpleDateFormat
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTimeInMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sd.format(calendar.getTime()));
		
		sd.setTimeZone(TimeZone.getTimeZone("Etc/Greenwich")); // 그리니치 표준 시로 위치 변경.
		System.out.println(sd.format(calendar.getTime()));
		
//		for(String name: TimeZone.getAvailableIDs()) {
//			System.out.println(name);
//		}
		
		
		System.out.println("-------------그레고리안");
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		
		System.out.println(gc.get(GregorianCalendar.YEAR));
		System.out.println(gc.get(Calendar.HOUR_OF_DAY));
		
		//윤년 인지 확인.
		System.out.println(gc.isLeapYear(2024)); // Calendar에는 없는 기능
	}

}
