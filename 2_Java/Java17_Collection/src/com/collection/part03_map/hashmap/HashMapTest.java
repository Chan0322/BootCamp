package com.collection.part03_map.hashmap;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	
	public void test() {
		//HashMap Test
		HashMap hmap = new HashMap();
		
		//put(), key, value
		hmap.put("one", new Date());
		hmap.put(12, "red apple"); //12=>Integer 객체
		hmap.put(34, 123);
		//key, value 모두 반드시 객체여야 한다.
		
		System.out.println("hmap: " + hmap);
		
		//키는 중복 허용X
		hmap.put(12, "yellow banana");
		System.out.println("hmap: " + hmap); // 동일한 key 값을 가지고 있으면 덮어씌워버림. key 값은 중복될 수 없다.
		
		//value는 중복 허용
		hmap.put(11, "yellow banana");
		hmap.put(19, "yellow banana");
		System.out.println("hmap: " + hmap);
		
		//value 가져오기
		System.out.println(hmap.get(19));
		
		//삭제하기
		hmap.remove(19);
		System.out.println(hmap);
		
		//갯수 확인
		System.out.println("hmap에 저장된 객체 수: " + hmap.size());
	}
	
	public void test2() {
		//map에 저장된 객체 연속 처리
		
		HashMap map = new HashMap();
		
		map.put("one", "비타500");
		map.put("two", "더벤티");
		map.put("three", "핸드크림");
		map.put("four", "에어팟");
		map.put("five", "칫솔");
		
		//1. keySet() - key만 set으로 만든다.
		Set keys = map.keySet();
		Iterator keyIt = keys.iterator(); // 목록화시킴. 키값들을 다 줄세움.
		while(keyIt.hasNext()) {
			String key = (String)keyIt.next();
			String val = (String)map.get(key);
			System.out.println(key+"="+val);
		}
		
		//2. entrySet() - Map의 내부클래스 Map.Entry를 set으로 만든다.
		//Entry = key+value 를 묶어놓은 객체
		Set set = map.entrySet();
//		System.out.println(set);
		Iterator entryIt = set.iterator();
		while(entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIt.next(); // entry를 가지고 온다.   가져온 것들이 Object 타입으로 가져오므로 형변환
			
//			System.out.println(entry.getKey() + "=" + entry.getValue());
			String key = (String)entry.getKey();
			String val = (String)entry.getValue();
			System.out.println(key+"="+val);
		}
		
		//3. values() - 저장된 value 값들만 Collection으로 만든다.
		Collection values = map.values();
		//Iterator(), toArray()
		Object[] arr = values.toArray();	// Object 타입의 배열로 리턴해줌
		for(int i=0; i<arr.length; i++) { // Object o : arr
			String val = (String)arr[i];
			System.out.println(val);
		}
	}
	
	public void test3() {
		//Score 클래스 객체 생성하여 map에 저장.
		HashMap map = new HashMap();
		
		map.put("1", new Score("이창진",100));
		map.put("2", new Score("김창진",90));
		map.put("3", new Score("박창진",80));
		
		System.out.println(map);
		
		map.clear(); // 초기화
		map.put(new Score(), "one");
		map.put(new Score("이창진",100), "one");
		map.put(new Score("김창진",90), "one");
		map.put(new Score("박창진",80), "one");
		
		System.out.println(map);
		
		map.put(new Score("이창진",100), "one");	// 해시코드와 equals 오버라이딩 전에는 같은 것으로 보지 못함. 오버라이딩 해 같은 것으로 인식
		
		System.out.println(map);
		
		map.put("key", new Score());	// 주로 key 값은 String 값으로 많이 사용.
	}
	
}
