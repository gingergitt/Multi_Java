package com.sds.finalpj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//테스트 실패
public class Hadoop {

	public static void main(String[] args) {

		try {
			
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://172.31.43.70:10000/default", "root", "111111");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Test");
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			conn.close();
			
			System.out.println("Success....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
