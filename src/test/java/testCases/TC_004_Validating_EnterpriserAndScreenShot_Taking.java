package testCases;

import org.testng.annotations.Test;

import pageObjects.EntrepreniurPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_Validating_EnterpriserAndScreenShot_Taking extends BaseClass {
	@Test(dataProvider="inputData",dataProviderClass=DataProviders.class)
	public void helper(String fname,String lname,String email,String phone,String title,String cName) throws Exception {
		logger.info("*******TestCase 4********* Started******");
		EntrepreniurPage ep= new EntrepreniurPage(driver);
		
//		ep.clickEntrepreniur();
		logger.info("Entering the details and filling the form");
		ep.enterDetails(fname,lname,email,phone,title,cName);
		logger.info("Successfully Filled");
		logger.info("*******TestCase 4 got executed Succesfully******");
		
	}

}
