package silsub4.model.vo;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	public Student() {}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String information() {
		String str = "";
		
		str += "학년: "+getGrade()+", ";
		str += "반: "+getClassroom()+", ";
		str += "이름: "+getName()+", ";
		str += "키: "+getHeight()+", ";
		str += "성별: "+getGender();
		return str;
	}
	
	
}
