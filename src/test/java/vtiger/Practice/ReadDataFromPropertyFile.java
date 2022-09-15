package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// step 1:load the file to file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//Step 2:Create object of properties from java
		Properties prop=new Properties();
		
		//Step 3:load file to properties object
		prop.load(fis);
		
		//step 4:read data using key
		String Browser = prop.getProperty("browser");
		System.out.println(Browser);
		
		String Url=prop.getProperty("url");
		System.out.println(Url);

	}

}
