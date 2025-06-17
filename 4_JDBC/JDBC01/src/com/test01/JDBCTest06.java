package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class JDBCTest06 {

	public static void main(String[] args) throws SQLException {
		// preparedStatement 활용하여 insert
		
		// 준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		int no = 13;
		String name = "SEO";
		String nickName = "SSSSS";
		
		
		//String sql = " INSERT INTO MYTEST VALUES("+no+", '"+name+"', '"+nickName+"')		
		String sql = " INSERT INTO MYTEST VALUES(?,?,?) ";
		
		
		// 연결
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);		// 첫번째 물음표는 no 값으로 채우겠다.
		pstm.setString(2, name);	// 두 번째 물음표는 name 값으로 채우겠다.
		pstm.setString(3, nickName);
		//" INSERT INTO MYTEST VALUES(10,'JANG','JJJ') "
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("insert 성공");
			con.commit();
		}else {
			System.out.println("insert 실패");
			con.rollback();
		}
		
		// 자동 커밋을 비활성화하고, 커밋을 하지 않은 상태로 close 하면 롤백처리됨.
		
//		JDBCTest05.select();
		
//		JDBCTest05.insert();
//		JDBCTest05.insert();
//		if(성공) commit
//		if(실패) rollback
		
		close(pstm); 	// PreparedStatement는 Statement의 하위 클래스이므로 처리 가능.
		close(con);
	}

}
