package silsub4.run;

import silsub4.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		Student s = new Student();
		
		s.setGrade(1);
		s.setClassroom(2);
		s.setName("홍길동");
		s.setHeight(180.0);
		s.setGender('남');
		
		System.out.println(s.information());
	}

}
