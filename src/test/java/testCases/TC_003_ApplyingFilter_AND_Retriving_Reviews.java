package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.FirstCourse;
import pageObjects.Home;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_ApplyingFilter_AND_Retriving_Reviews extends BaseClass   {
	
	@Test(dataProvider="searchData",dataProviderClass=DataProviders.class)
	public void SearchCourse(String s) {
		logger.info("********TestCase 3 Started*********");
		Home home=new Home(driver);
		home.searchWebDevelopment(s);
//		Thread.sleep(5000);
	}
	
	@Test
	public void helper() throws IOException {
//		TC_002_SearchingCourse tc_002_SearchingCourse = new TC_002_SearchingCourse();
//		tc_002_SearchingCourse.SearchCourse();
		
		logger.info("Filteriing......");
		CoursesPage cp=new CoursesPage(driver);
		logger.info("Applying Language Filter so clicking langugae filter.......");
		cp.clickLanguage();
		logger.info("Clicked langugae filter sucessfully .......");
		logger.info("Selecting English Language filter.......");
		cp.selectEnglish();
		logger.info("****Selected English Language filter Sucesssfully***.......");
		logger.info("Clicking view button  .......");
		cp.clickView();
		logger.info("Clicked view button  Sucesfully.......");
		logger.info("Applying Level Filter so clicking Level filter.......");
		cp.clickLevel();
		logger.info("Clicked Level button  Sucesfully.......");
		logger.info("****Selected Beginner Level ***.......");
		cp.selectBeginerLevel();
		logger.info("****Selected Beginner Level filter Sucesssfully***.......");
		logger.info("Clicking view button  .......");
		cp.clickView();
		logger.info("Clicked view button  Sucesfully.......");
		cp.Waiting();
		FirstCourse f1=new FirstCourse(driver);
		f1.clickCourses();
		cp.RatingsOfAllCards(2);
		logger.info("......Sucessfully Test case 3 finished and details printed......");
		logger.info("*******TestCAse 3 Executed Sucessfully********");
		
	}

}
