package com_part03_wrapperStream.test3;

import java.util.Objects;

//객체로 입출력하기 위해서는 직렬화 처리가 필요하다.Serializable : 데이터를 byte 별로 쪼개는거.    역직렬화 : 쪼갠걸 다시 합치는거.
public class Member implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // id를 부여해 클래스가 수정되더라도 직렬화한 클래스와 같은 클래스임을 확인할 수 있게 하여 문제없이 동작함.
	
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private int age;
	private char gender;
	private double point;
	
	String addr;
	
	//생성자
	public Member() {}
	public Member(String userId, String userPwd, String userName, String email, int age, char gender, double point) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.point = point;
	}
	//getter, setter
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, email, gender, point, userId, userName, userPwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(email, other.email) && gender == other.gender
				&& Double.doubleToLongBits(point) == Double.doubleToLongBits(other.point)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPwd, other.userPwd);
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", age=" + age + ", gender=" + gender + ", point=" + point + "]";
	}
	
	
}
