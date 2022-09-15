package vitiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This method reads data from property file and returns value
 * @author HP
 *
 */
public class PropertyFileUtility {
	public String readFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.PropertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
