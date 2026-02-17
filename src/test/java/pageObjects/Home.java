package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Home extends BasePage{
	public Home(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='search-autocomplete-input']")
	WebElement search;
	@FindBy(xpath="//span[text()='Results for \"web development\"']")
	WebElement result;
	
	public void searchWebDevelopment(String s) {
		search.clear();
		type(search,s);
		pressEnterKey(search,Keys.ENTER);
	
	}
	
	public String Result() {
		return getText(result);
	}
	

}
