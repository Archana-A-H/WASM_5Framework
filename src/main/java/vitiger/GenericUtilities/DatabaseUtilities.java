package vitiger.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtilities 
{
    Driver driverRef;
	Connection con=null;
	/**
	 * This method establishes connection with data base
	 * @throws SQLException
	 */
    public void connectToDB() throws SQLException
    {
    	driverRef=new Driver();
    	DriverManager.registerDriver(driverRef);
    	con=DriverManager.getConnection(ConstantsUtility.DBUrl,ConstantsUtility.DBUsername,ConstantsUtility.DBPassword);
    }
    /**
     * This method closes data base connection
     * @throws SQLException
     */
    public void closeDB() throws SQLException
    {
    	con.close();
    }
    /**
     * This method checks if expected data is found or not
     * if found it returns expected data
     * if not found it returns null
     * @param query
     * @param colindex
     * @param expdata
     * @return
     * @throws SQLException
     */
    public String executeQueryAndVerifyData(String query,int colindex,String expdata) throws SQLException
    {
    	boolean flag=false;
    	ResultSet result = con.createStatement().executeQuery(query);
    	while(result.next())
    	{
    		String aData = result.getString(colindex);
    		if(aData.equals(expdata)) 
    		{
    			flag=true;
    			break;
    		}
    	}
    	if(flag)
    	{
    		System.out.println("Data is present"+expdata);
    		return expdata;
    	}
    	else
    	{
    		System.out.println("Data is not present");
    		return "";
    	}
    }
}
