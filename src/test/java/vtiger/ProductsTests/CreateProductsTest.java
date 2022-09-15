package vtiger.ProductsTests;

import java.io.IOException;

import org.testng.annotations.Test;

import vitiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewProduct;
import vtiger.ObjectRepository.CreateNewProductInfo;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductsPage;

public class CreateProductsTest extends BaseClass{

	@Test(groups="SmokeSuite")
	public void CreateNewProdTest() throws IOException {
		
		  String Productname = eUtil.readFromExcelSheet("Products", 1, 2);
		  
		
          //Navigate to products link
          HomePage hp=new HomePage(driver);
          hp.ClickOnProducts();
          
          //Click on create product image
          ProductsPage pp=new ProductsPage(driver);
          pp.ClickOnCreateProdImg();
          
          //Create new Product
          CreateNewProduct np=new CreateNewProduct(driver);
          np.CreateProduct(Productname);
          
          //validate
          CreateNewProductInfo pi=new CreateNewProductInfo(driver);
          String pHeader = pi.gatProdInfoHeaderText();
          if(pHeader.contains(Productname))
          {
        	  System.out.println("product created successfully");
        	  System.out.println(pHeader);
          }
          else
          {
        	  System.out.println("product not created");
          }
         
	}

}
