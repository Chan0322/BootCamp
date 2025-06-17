package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//jdbc를 통해
		//사번, 사원명, 직급명, 부서명, 급여, 보너스를 조회하여
		//출력문으로 출력해 확인
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "MULTI";
		String pw = "MULTI";
		
		Connection con = DriverManager.getConnection(url, id, pw);
		
		Statement stmt = con.createStatement();
		
		// 헷갈리면, DBeaver에서 먼저 실행하고 확인하자!
		String sql = " SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY, BONUS "
				   + " FROM EMPLOYEE "
				   + " LEFT JOIN JOB USING(JOB_CODE) "
				   + " LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) ";

		ResultSet rs = stmt.executeQuery(sql);
		
//		ResultSet rs = stmt.executeQuery(
//				"SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY, BONUS "
//				+ "FROM EMPLOYEE "
//				+ "LEFT JOIN JOB USING(JOB_CODE) "
//				+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) ");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " "
							   +rs.getString(2) + " "
							   +rs.getString(3) + " "
							   +rs.getString("DEPT_TITLE") + " "
							   +rs.getInt(5)+" "
							   +rs.getDouble(6));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}

}
