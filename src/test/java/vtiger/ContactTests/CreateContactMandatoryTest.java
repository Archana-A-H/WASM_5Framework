package vtiger.ContactTests;

import java.io.IOException;

import org.testng.annotations.Test;

import vitiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

public class CreateContactMandatoryTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void createConMandatoryTest() throws IOException {
		
		
		String Lastname = eUtil.readFromExcelSheet("Contacts", 1, 2);
		
		
			
		//Navigate to Contacts link	
			HomePage hp=new HomePage(driver);
			hp.clickOnContacts();
			
		//Create contact
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateNewContactImg();
			
		//Create new Contact with mandatory Fields
			CreateNewContactPage cnp=new CreateNewContactPage(driver);
			cnp.createNewContact(Lastname);
			
		//Validate
			CreateContactInfoPage ci=new CreateContactInfoPage(driver);
			String conHeader = ci.getContactHeader();
			if(conHeader.contains(Lastname))
			{
				System.out.println("Contact created Successfully");
				System.out.println(conHeader);
			}
			else
			{
				System.out.println("Contact not created");
			}
			
			
	}

}
