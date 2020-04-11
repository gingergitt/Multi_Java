package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {
	private static LoginDB instance = new LoginDB();

	public static LoginDB getInstance() {
		return instance;
	}

	public LoginDB() {
	}

	// oracle ∞Ë¡§
	String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	String jdbcUrl = "jdbc:oracle:thin:@192.168.0.3:1521:xe";

	String userId = "NY";
	String userPw = "NY";

	Connection conn = null;
	Connection conn2 = null;

	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;

	String sql = "";
	String result = "";

	public String loginnDB(String id, String pwd) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, userId, userPw);

//			System.out.println("---------------------");
//			System.out.println(id);
//			System.out.println(pwd);

//			sql = "SELECT * FROM USERS WHERE USERID = ? AND USERPWD =?";
			sql = "SELECT USERID,USERPWD FROM USERS WHERE USERID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

			rs = pstmt.executeQuery();
//age gender phone email agree
			if (rs.next()) {
					String qpwd =  rs.getString("userpwd");
					System.out.println("qpwd="+qpwd);
					System.out.println("pwd="+pwd);
					
				if (qpwd.equals(pwd)) {
					return "1";

				
				}else {
					return "0";
				}
			} 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return "0";

	}
}
