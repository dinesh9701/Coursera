package testCases;

import org.testng.annotations.Test;

import pageObjects.LanguageLearningPage;
import pageObjects.LanguageLeraning;
import testBase.BaseClass;

import java.io.IOException;

public class TC_005_LanguageLearning extends BaseClass {
	@Test(priority = 1)
	public void languageDetails() throws IOException {
		logger.info("*****TestCase 5 Started********");
		LanguageLeraning ll=new LanguageLeraning(driver);
		//Thread.sleep(5000);
		logger.info("Clicking the learning Leanguage");
		ll.function();
		logger.info("Succesfully clicked the learning Leanguage");



		LanguageLearningPage lp=new LanguageLearningPage(driver);
		logger.info("Lanugage ShowingAll Language clicking.....");
		lp.showAllLanguages();
		logger.info("Lanugage ShowingAll Sucessed.....");
		System.out.println("Clicked");
		logger.info("Caputuring languages and writing in excel sheet");
		lp.captureLanguages();
		logger.info("*****Caputuring languages and writing in excel sheet Got Sucessed******");
		logger.info("Caputuring Levels and writing in excel sheet");

		lp.captureLevels();
		logger.info("*****Caputuring Levels and writing in excel sheet Got Sucessed******");

	}


}
