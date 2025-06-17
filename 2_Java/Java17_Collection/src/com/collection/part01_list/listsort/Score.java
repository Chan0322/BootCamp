package com.collection.part01_list.listsort;

public class Score implements Comparable<Score> {
	private String name;
	private int point;
	
	//생성자(기본, 매개변수)
		//getter, setter
		//toString
	
	public Score() {}
	public Score(String name, int point) {
		this.name = name;
		this.point = point;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", point=" + point + "]";
	}
	
	@Override
	//name 오름차순 정렬
	public int compareTo(Score o) {
		//비교되는 두 값을 기준으로
		//양수를 리턴하면 바꾼다. 음수를 리턴하면 안바꾼다.
		
		String otherName = o.getName();
		
		return name.compareTo(otherName);
		//음수.  자리 바꾸지 않겠다.
		//양수.  자리 바꾸겠다.
		//0.   제자리
		
		//String의 기본 정렬기준인 오름차순을 그대로 따라서
		//name 오름차순 정렬된다.
		//return -name.compareTo(otherName);는 반대로. 내림차순 정렬
		//"나".compareTo("가");  ==> 양수
		//바꿀꺼다! => 양수 리턴,
		//안바꿀꺼다! => 음수 리턴
	}
	
}
