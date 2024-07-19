package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FeatchDataFromDtatabase {

	public static void main(String[] args) throws Throwable {
		//step:1registor/load the mysql data base
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step:2-get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "root");
		
		//step:3 create sql statement
		Statement state = conn.createStatement();
		String query = "select * from student";
		
		//step:4 execute statement
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(0)+"\t"+result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t");
		}

		//step:5 close the connection
		conn.close();
	}

}
