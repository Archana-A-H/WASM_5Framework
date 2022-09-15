package vtiger.ContactTests;

import java.io.IOException;

import org.testng.annotations.Test;

import vitiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganization;
import vtiger.ObjectRepository.CreateOrganizationInfo;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createConOrgTest() throws IOException {
		
		String Orgname = eUtil.readFromExcelSheet("Contacts", 1, 3)+jUtil.getRandomNumber();
		String Lastname = eUtil.readFromExcelSheet("Contacts", 1, 2);
		
		
		//Navigate to organizations link
			HomePage hp=new HomePage(driver);
			hp.clickOnOrg();
			
		//Click on create new organizations image
			OrganizationsPage op=new OrganizationsPage(driver);
			op.ClickOnCreateNewOrgImg();
			
		//Create new Organization
		  CreateNewOrganization cno=new CreateNewOrganization(driver);
		  cno.createNewOrg(Orgname);
		  
		 //validate
		   CreateOrganizationInfo coi=new CreateOrganizationInfo(driver);
		   String OrgHeader = coi.getOrgHeader();
		   if(OrgHeader.contains(Orgname))
		   {
			   System.out.println("Organization created succesfully");
			   System.out.println(OrgHeader);
		   }
		   else
		   {
			   System.out.println("Organization not created");
		   }
		   
		  //Navigate to contacts link
		   hp.clickOnContacts();
		   
		   //Click on Create contact image
		   ContactsPage cp=new ContactsPage(driver);
		   cp.clickOnCreateNewContactImg();
		   
		   //create contact with existing organization
		   CreateNewContactPage cnc=new CreateNewContactPage(driver);
		   cnc.ClickOnExistingOrgImg(driver, Orgname, Lastname);
		   
		   //validate
		   CreateContactInfoPage cci=new CreateContactInfoPage(driver);
		   String cHeader = cci.getContactHeader();
		   if(cHeader.contains(Lastname))
		   {
			   System.out.println("contact created succesfully");
			   System.out.println(cHeader);
		   }
		   else
		   {
			   System.out.println("contact not created");
		   }
		   
		   
	}

}
