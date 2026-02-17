package duplicate;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Duplicate1 {
	
	WebDriver driver;
	WebDriverWait wait;
	String main="";
	@BeforeTest
	public void setUp() {
		
	driver=new ChromeDriver();
	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://www.coursera.org/");
	
	}
	
	
	@Test
	public void newCase() throws Exception{
		

		WebElement explore=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Explore\"]")));
		Actions a=new Actions(driver);
		a.moveToElement(explore).click().perform();
		WebElement langLear=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Language Learning']")));
		a.moveToElement(langLear).click().perform();
//		WebElement filters=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"Filters\")]")));
////		parent::button/parent::div
//		a.moveToElement(filters).click().perform();
//		WebElement language=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Language\"]/ancestor::button")));
//		a.moveToElement(language).click().perform();
		List<WebElement> languages=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"css-j7pf8u\"]")));
		System.out.println(languages.size());
		for(WebElement x:languages) {
			a.moveToElement(x).click().perform();
			List<WebElement> helper=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Level\"]/parent::h4/following-sibling::div//div[@class=\"css-j7pf8u\"]")));
			for(WebElement y: helper) {
				a.moveToElement(y).click().perform();
				
			}
//			WebElement Level=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Level']/ancestor::button")));
//			a.moveToElement(Level).click().perform();
//			WebElement beg=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Beginner\"]/child::span")));
//			System.out.println(beg.getText());
//			WebElement inter=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()=\"Intermediate\"]/child::span")));
//			System.out.println(inter.getText());
//			WebElement adv=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()=\"Advanced\"]/child::span")));
//			System.out.println(adv.getText());
//			WebElement mix=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()=\"Mixed\"]/child::span")));
//			System.out.println(mix.getText());
			
			}
		
	}
	@AfterTest
	public void terminate() {
		if (driver != null) {
	        try {
//	            Thread.sleep(1000);
	        	// optional pause
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	        driver.quit(); // clean shutdown
	    }

}
