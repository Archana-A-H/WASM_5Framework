package vtiger.OrganizationsTests;

import java.io.IOException;

import org.testng.annotations.Test;

import vitiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganization;
import vtiger.ObjectRepository.CreateOrganizationInfo;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationMandatoryTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void createOrgMandatoryTest ()  throws IOException {
		
		
		  String Orgname = eUtil.readFromExcelSheet("Organization", 1, 2)+jUtil.getRandomNumber();
		  
		
		 
		  //Navigate to Organizations Link
		   HomePage hp=new HomePage(driver);
		   hp.clickOnOrg();
		  
		  //click on create organization image 
		   OrganizationsPage op=new OrganizationsPage(driver);
		   op.ClickOnCreateNewOrgImg();
		   
		  //create new organization
		   CreateNewOrganization cnp=new CreateNewOrganization(driver);
		   cnp.createNewOrg(Orgname);
		   
		  //validate
		   CreateOrganizationInfo ci=new CreateOrganizationInfo(driver);
		   String orgHeader = ci.getOrgHeader();
		   if(orgHeader.contains(Orgname))
		   {
			   System.out.println("ORGANIZATION CREATED SUCCESFULLY");
			   System.out.println(orgHeader);
		   }
		   else
		   {
			   System.out.println("ORGANIZATION NOT CREATED");
		   }
		 
	}

}
