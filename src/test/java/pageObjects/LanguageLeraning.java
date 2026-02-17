package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageLeraning extends BasePage {
	
	public LanguageLeraning(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()=\"Explore\"]")
	WebElement explore;
	
	@FindBy(xpath="//a[text()='Language Learning']")
	WebElement languageLearning;
	
	public void function() {
		actionClick(explore);
		actionClick(languageLearning);
	}
	
	

}
