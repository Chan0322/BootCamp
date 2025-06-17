package silsub1.run;

import silsub1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member m = new Member();
		m.setMemberId("user");
		m.setMemberPwd("1234");
		m.setMemberName("홍길동");
		m.setAge(25);
		m.setGender('M');
		m.setPhone("010-1234-5678");
		m.setEmail("user@naver.com");
		
		String str = "";
		str += m.getMemberId()+",";
		str += m.getMemberPwd()+",";
		str += m.getMemberName()+",";
		str += m.getAge()+",";
		str += m.getGender()+",";
		str += m.getPhone()+",";
		str += m.getEmail();
		
		System.out.println(str);
	}

}
