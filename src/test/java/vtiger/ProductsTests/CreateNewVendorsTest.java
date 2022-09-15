package vtiger.ProductsTests;

import java.io.IOException;

import org.testng.annotations.Test;

import vitiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewVendor;
import vtiger.ObjectRepository.CreateVendorInfo;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.VendorsPage;

public class CreateNewVendorsTest extends BaseClass{

	@Test(groups="RegionalRegression")
	public void CreateVendorTest() throws IOException {
		
		  
		  String Vendorname = eUtil.readFromExcelSheet("Products", 1, 3);
		  
		
          //Navigate to vendors Link
          HomePage hp=new HomePage(driver);
          hp.ClickOnVendors(driver);
          
          //Click on create new vendor image
          VendorsPage vp=new VendorsPage(driver);
          vp.ClickOnCreateVendorImage();
          
          //create new vendor 
          CreateNewVendor cnv=new CreateNewVendor(driver);
          cnv.CreateVendor(Vendorname);
          
          //validate
           CreateVendorInfo ci=new CreateVendorInfo(driver);
           String vHeader = ci.getVendorInfoText();
           if(vHeader.contains(Vendorname))
           {
        	   System.out.println("VENDOR CREATED SUCCESFULLY");
        	   System.out.println(vHeader);
           }
           else
           {
        	   System.out.println("VENDOR NOT CREATED");
           }
		  
          


	}

}
