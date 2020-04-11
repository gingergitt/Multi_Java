package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Test {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://192.168.111.102/shop";
		String id = "muser";
		String pwd = "111111";
		String sql = "Select * from USERS";
				
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,id,pwd);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rset = pstmt.executeQuery();
		
		while(rset.next()) {
			String idd = rset.getString("id");
			String pwdd = rset.getString("pwd");
			String name = rset.getString("name");
			int age = rset.getInt("age");
			System.out.println(idd+" "+pwdd+" "+name+" "+age);
		}
		
		rset.close();
		pstmt.close();
		con.close();

	}

}
