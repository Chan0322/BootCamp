package com.collection.part02_set.hashset;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public void test() {
		HashSet hset = new HashSet();
//		Set hset2 = new HashSet();
		
		//데이터 추가
		//객체만 저장 가능하다.
		hset.add("Java");
		hset.add(123);		//wrapper클래스로 객체화 되어 저장.
		hset.add(45.67);
		hset.add(new Date());
		
		//순서 유지 안된다.
		System.out.println("hset: " + hset);
		
		//중복 허용 안한다.
		hset.add("Java");
		hset.add(123);
		System.out.println("hset: " + hset);
		System.out.println("저장된 객체 수: " + hset.size());
		System.out.println("포함 확인: " + hset.contains(123));
		
		//저장된 객체를 하나씩 접근
		//Iterator사용
		//Iterator() 메소드 : 저장된 객체를 목록으로 만들어 준다. 줄을 세운다.
		Iterator it = hset.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()); // 다음 객체로 커서 이동
		}
		System.out.println("한번더!!");	// 일회용임. 한번 더 불가. 다시하고 싶으면 Iterator 다시 만들어서 진행.
//		it = hset.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()); // 다음 객체로 커서 이동
		}
		
		//toArray()사용.
		Object[] ar = hset.toArray();
		for(int i=0; i<ar.length; i++) {
			System.out.println(i+":"+ar[i]);
		}
		
		//삭제
		hset.remove(123);
		System.out.println(hset);
		hset.clear(); // 전체 삭제
		System.out.println("비었나? "+hset.isEmpty());
	}
	
	public void test2() {
		//데이터 중복 저장
		Set<Member> set = new HashSet<Member>();
		//<Member> => 제네릭. 해당하는 객체만 사용하겠다 선언
		
		set.add(new Member("이창진",20,"010-1234-4321"));
		set.add(new Member("김창진",30,"010-3333-4444"));
		set.add(new Member("박창진",40,"010-4444-5555"));
		
		//set.add(set); 에러 발생. 지금 set에는 Menber클래스 객체만 저장 가능.
		System.out.println(set);
		
		set.add(new Member("이창진",20,"010-1234-4321"));
		set.add(new Member("김창진",30,"010-3333-4444"));
		// new 연산자를 사용해서 객체를 새롭게 만들었으므로 다른 객체로 판단하고 생성이 되버림.
		System.out.println(set);
		
		//hashcode, equals를 오버라이딩    => 안의 내용이 같으면 동일한 객체라고 판단하도록하여 중복된 내용이 추가되지 않음.
	}
}
