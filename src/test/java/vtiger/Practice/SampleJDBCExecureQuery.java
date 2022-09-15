package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecureQuery {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		Statement state=con.createStatement();
		ResultSet result=state.executeQuery("select * from customerinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		con.close();

	}

}
