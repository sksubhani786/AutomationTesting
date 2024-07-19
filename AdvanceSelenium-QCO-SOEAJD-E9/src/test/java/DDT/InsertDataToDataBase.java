package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {
		//step:1registor/load the mysql data base
				Driver driverref = new Driver();
				DriverManager.registerDriver(driverref);
				
				//step:2-get connection to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "root");
				
				//step:3 create sql statement
				Statement state = conn.createStatement();
				
				String query = "insert into student(first_name,lastname_name,address)values('subhani','shaik''blre')";

				int result = state.executeUpdate(query);
				
				if(result==1) {
					System.out.println("data is updated");
					
				}
				else {
					System.out.println("data is not updated");
				}
				conn.close();
	}

}
