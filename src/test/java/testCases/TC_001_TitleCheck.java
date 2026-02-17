package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;



public class TC_001_TitleCheck extends BaseClass {
	
	@Test
	public void TitleChcek() {
		logger.info("****** TestCase 1 Started  *******");
        logger.info("Getting Title......");
		String title=driver.getTitle();
        logger.info("Checking for validations of titles");
        String expected="Coursera | Courses, Professional Certificates, and Degrees Online";
        if(expected.equals(title)) {
			Assert.assertTrue(true,"Title Matched Correctly");
			logger.info("Assert got susceeeded Title Matched Correctly ");
	        logger.info("TestCase 1 Executed Sucessfully");
		}
		else {
			Assert.assertTrue(false,"Title Mismatched so opened Wrong page");
			logger.info("Assert got Failed Title MissMatched  ");
	        logger.info("-----TestCase 2 Failed-----");
			
			
		}
//        logger.info("TestCase 1 Executed Sucessfully");
//		Assert.assertEquals(title,expected );
	}

}
