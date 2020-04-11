package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection conn = DriverManager.getConnection

		("jdbc:hive2://192.168.111.201:10000/default","root","111111");
		Statement stmt = conn.createStatement();
		String sql = "SELECT year,month,AVG(ArrDelay),AVG(DepDelay) FROM airline_delay GROUP BY year,month";
		ResultSet rs = stmt.executeQuery(sql);
		   while(rs.next()) {
		     System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		   }
		conn.close();
		System.out.println("Success....");

	}

}
