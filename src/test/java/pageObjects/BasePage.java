package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		PageFactory.initElements(driver,this);
	}
	
	//clicking an Element or button action
	public void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	//Typing something into inputField
	
	public void type(WebElement element,String input) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(input);
	}
	
	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	// Wait for element visible
	public void waitForVisibility(WebElement element) 
	{ 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//wait for element clickable
	public void waitForClickability(WebElement element) 
	{ 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//MultipleElements
	public void waitOfAllVisibility(List<WebElement> element) 
	{ 
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	//Action
	
	public void actionClick(WebElement element) {
		Actions a=new Actions(driver);
		waitForClickability(element);
		a.moveToElement(element).click().perform();
	}
	//Enter Key using keyboard
	public void pressEnterKey(WebElement element, Keys key) { 
		waitForVisibility(element);
		element.sendKeys(key);
		}
	
	public void SelecetDropDownByVisbilityOfText(WebElement element, String s) {
		Select select=new Select(element);
		select.selectByVisibleText(s);
		
	}
	public void SelecetDropDownByIndex(WebElement element, int i) {
		Select select=new Select(element);
		select.selectByIndex(i);
		
	}
	
	public void takeScrrenshot() throws IOException {
		File destDir = new File("C:\\Users\\2462034\\OneDrive - Cognizant\\Documents\\Autmationmajor\\MajorProject\\target\\screenShotsss1");
//		FileUtils.copyFile(screenshot, new File("C:\\Automation\\MyWorkSpace\\seleniumWebDriver\\MajorProject\\target\\screenshots\\example.png"));
		File destFile = new File(destDir, "formTest.png");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Save to desired location
		
		FileUtils.copyFile(screenshot, destFile);
	}
	

}
