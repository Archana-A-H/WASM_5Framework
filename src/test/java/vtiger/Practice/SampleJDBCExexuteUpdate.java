package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExexuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver dr=new Driver();
		Connection con=null;
		try {
		DriverManager.registerDriver(dr);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		Statement state=con.createStatement();
		String query="insert into customerinfo values('Tyler',18,'Madrid')";
		int result=state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data is inserted Successfully");
		}
		else
		{
			System.out.println("Data insertion failed");
		}
		}
		catch(Exception e)
		{
		  	//Handle exception
		}
		finally {
		con.close();
		System.out.println("DataBase Closed");
		}

	}

}
