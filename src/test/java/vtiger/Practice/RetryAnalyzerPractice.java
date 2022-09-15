package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer=vitiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void retryAnalyzerTest()
	{
		System.out.println("RETRY ANALYZER SAMPLE");
		Assert.fail();
	}
	

}
