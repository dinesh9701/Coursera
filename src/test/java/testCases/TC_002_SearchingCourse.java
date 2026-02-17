package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_SearchingCourse extends BaseClass {
	
	@Test(dataProvider="searchData",dataProviderClass=DataProviders.class)
	public void SearchCourse(String s) {
		logger.info("******TestCase 2  Started *****");
		logger.info("***** Searching WebDevelopment ******");
		Home home=new Home(driver);
		home.searchWebDevelopment(s);
		
		String expected="Results for \"web development\"";
		String res=home.Result();
		if(expected.equals(res)) {
			
			Assert.assertTrue(true,"Searched correct course WebDevelopment");
			logger.info("Searched correct course and Assert got succes");
		}
		else {
			Assert.assertTrue(false,"Failed searched a wrong Course");
			logger.info("Searched Wrong correct course and Assert got Failed....(* *)");
			logger.info("Searched Wrong correct course and Assert got Failed....( F )");
			
		}
		logger.info("***Succesfully searched***");
		logger.info("***** TestCase 2 Executed Succesfully*****");
//		Thread.sleep(5000);
	}

}
