package vitiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retryCount=4;
	
	public boolean retry(ITestResult result)
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
