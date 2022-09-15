package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vitiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganization;
import vtiger.ObjectRepository.CreateOrganizationInfo;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgIndTypePOMTest extends BaseClass{

	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void CreateOrganizationTypeTest() throws EncryptedDocumentException, IOException {
		
		
		// Read all necessary data
		  
		  String Orgname = eUtil.readFromExcelSheet("Organization", 1, 2)+jUtil.getRandomNumber();
		  String Industry = eUtil.readFromExcelSheet("Organization", 1, 3);
		  //String Type = eUtil.readFromExcelSheet("Organization", 1, 4);
		  
		  
		
		  //Navigate to Organizations Link
		   HomePage hp=new HomePage(driver);
		   hp.clickOnOrg();
		  
		  //click on create organization image 
		   OrganizationsPage op=new OrganizationsPage(driver);
		   op.ClickOnCreateNewOrgImg();
		  
		  //Create organization with industry and type 
            CreateNewOrganization cno=new CreateNewOrganization(driver);
             cno.createNewOrg(Orgname, Industry);
            //cno.createNewOrg(Orgname, 5);
            
          //validate
            CreateOrganizationInfo oi=new CreateOrganizationInfo(driver);
            String orgHeader = oi.getOrgHeader();
            if(orgHeader.contains(Orgname))
            {
            	System.out.println("ORGANIZATION CREATED SUCCESSFULLY");
            	System.out.println(orgHeader);
            }
            else
            {
            	System.out.println("ORGANIZATION NOT CREATED");
            }
            
          
	}

}
