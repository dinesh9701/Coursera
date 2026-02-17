package duplicate;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Main {
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
	
	@Test(priority=0)
	public void search() {
		WebElement search=driver.findElement(By.xpath("//*[@id='search-autocomplete-input']"));
		search.sendKeys("web development"+ Keys.ENTER);
//		WebElement searchele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"query\"]")));
//		searchele.sendKeys("Web Development"+Keys.ENTER);
		
	}
	@Test(priority=1)
	public void applyFilters()throws Exception {
		WebElement language=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"Language\"]")));
		language.click();
		
		Actions a=new Actions(driver);
		
		WebElement english=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"English\"]/ancestor::div[1]/preceding-sibling::span")));
		a.moveToElement(english).click().perform();
		
		WebElement view=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"View\"]/parent::button")));
		a.moveToElement(view).click().perform();
		
		WebElement level=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"Level\"]")));
		level.click();
		
		WebElement beginner=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Beginner\"]/ancestor::div[1]/preceding-sibling::span")));
		a.moveToElement(beginner).click().perform();
		
		view=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"View\"]/parent::button")));
		a.moveToElement(view).click().perform();
	}
	@Test(priority=2)
	public void findUl()throws Exception{
		List<WebElement> uls=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class=\"cds-9 css-5t8l4v cds-10\"]/preceding-sibling::ul/li")));
		WebElement item1=uls.get(0);
		System.out.println(uls.size());
		main+=driver.getWindowHandle();
		
		WebElement rating=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Rating')]")));
		System.out.println(rating.getText());
		item1.click();
	
//		Thread.sleep(100000);
//		WebElement title=driver.findElement(By.xpath("//h3[text()=\"Introduction to HTML, CSS, & JavaScript\")]"));
//		System.out.println(title.getText());
//		int i=0;
//		Set<String>s1=driver.getWindowHandles();
//	
//		for(String x:s1) {
//			
//			System.out.println(x);
//			if(i==1) {
//				driver.switchTo().window(x);
//			}
//			i++;
//		}
	}
	
	@Test(priority=3)
	
	public  void details() throws Exception{
		
		Thread.sleep(10000);
		int i=0;
		Set<String>s1=driver.getWindowHandles();
	
		for(String x:s1) {
			
			System.out.println(x);
			if(i==1) {
				driver.switchTo().window(x);
			}
			i++;
		}
//		WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='css-oe48t8']//div[2]/h1")));
		WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
		System.out.println(title.getText());
//		Thread.sleep(10000);
//		WebElement rating=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class=\"css-oe48t8\"]/child::div/child::div/child::div/following-sibling::div/child::div[2]/child::div/child::div[2]/child::div/child::div[1]")));
//		System.out.println(rating.getText());
//		WebElement closeButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"cds-212\"]/following-sibling::button")));
//		closeButton.click();
		//Main rating
//		WebElement rating = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'reviews')]/parent::p/preceding-sibling::span")));
//		System.out.println(rating.getText());
		// Create a FluentWait instance
//		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
//		        .withTimeout(Duration.ofSeconds(20))        // maximum wait time
//		        .pollingEvery(Duration.ofMillis(500))       // check every 500ms
//		        .ignoring(NoSuchElementException.class)     // ignore if element not found
//		        .ignoring(StaleElementReferenceException.class); // ignore stale element issues
//
//		// Use FluentWait to locate the rating element
//		WebElement rating = fluentWait.until(driver -> 
//		        driver.findElement(By.xpath("//span[contains(text(),'reviews')]/parent::p/preceding-sibling::span"))
//		);
//
//		// Print the text
//		System.out.println(rating.getText());

		// Create FluentWait instance
//		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
//		        .withTimeout(Duration.ofSeconds(20))        // total wait time
//		        .pollingEvery(Duration.ofSeconds(5))       // check every 500ms
//		        .ignoring(NoSuchElementException.class) ;    // ignore if element not found
//		    // ignore stale element issues
//
//		// Use FluentWait to locate the rating element
//		WebElement rating = fluentWait.until(driver -> 
//		        driver.findElement(By.xpath("//div[@class='css-139h6xi']/child::div"))
//		);

		// Interact with the element
//		System.out.println(rating.getText());

//		List<WebElement> l2=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"css-fndret\"]/child::div")));
//		System.out.println("Size of L2 is "+l2.size());
		
		List<WebElement> l3=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'hours')]")));
		System.out.println("Size of L2 is "+l3.size());
		int total=0;
		for(WebElement x: l3) {
			String s=x.getText();
			char c=s.charAt(0);
			int n=c-'0';
			total+=n;
			System.out.println(x.getText());
			
		}
		System.out.println("Total Number of hours are "+ total+" Hours");
		driver.close();
		driver.switchTo().window(main);
		System.out.println(driver.getTitle());
	}
		@Test(priority=4)
		public void second() throws Exception {
			List<WebElement> uls=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class=\"cds-9 css-5t8l4v cds-10\"]/preceding-sibling::ul/li")));
			WebElement item1=uls.get(1);
			item1.click();
			details();
		}
		
		@Test(priority=5)
	public void form()throws Exception {
			WebElement enterprise=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='For Enterprise']")));
			enterprise.click();
//			String curr=driver.getWindowHandle();
//			driver.switchTo().window(curr);
			WebElement fname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName']")));
			fname.sendKeys("jagh");
			WebElement lname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='LastName']")));
			lname.sendKeys("jaghajkgs");
			WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
			email.sendKeys("jagakjsbcmh");
			WebElement Phone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Phone']")));
			Phone.sendKeys("198e68763`1");
			WebElement otype=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='rentalField9']")));
			Select select = new Select(otype);
			select.selectByIndex(1);
//			otype.click();
			WebElement jtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"Title\"]")));
			jtitle.sendKeys("nas,bsbanz MBxBxn zvgshav xmzn");
			
			WebElement cname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"Company\"]")));
			cname.sendKeys("iuqwsanjmzal");
			
			WebElement csize=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"Employee_Range__c\"]")));
			Select select2 = new Select(csize);
			select2.selectByIndex(1);
		
			WebElement des=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='Self_Reported_Needs__c']")));
			Select select3 = new Select(des);
			select3.selectByIndex(1);
			
			WebElement country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"Country\"]")));
			Select select4 = new Select(country);
			select4.selectByVisibleText("India");
			
			WebElement state=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"State\"]")));
			Select select5 = new Select(state);
			select5.selectByVisibleText("Telangana");
			
			WebElement urDesc=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
			urDesc.sendKeys("nas,bsbanz MBxBxn zvgshav xmznjbksajmbs azbouh1	polK,a:lNajbxhav");
			
			WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
			submit.click();
			Thread.sleep(5000);
			File destDir = new File("C:\\Automation\\MyWorkSpace\\seleniumWebDriver\\MajorProject\\target\\screenShotsss1");
//			FileUtils.copyFile(screenshot, new File("C:\\Automation\\MyWorkSpace\\seleniumWebDriver\\MajorProject\\target\\screenshots\\example.png"));
			File destFile = new File(destDir, "formTest.png");
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Save to desired location
			
			FileUtils.copyFile(screenshot, destFile);

			
		}
		@Test(priority=6)
		public void newCase() throws Exception{
			
			driver.navigate().back();
			WebElement explore=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Explore\"]")));
			Actions a=new Actions(driver);
			a.moveToElement(explore).click().perform();
			WebElement langLear=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Language Learning']")));
			a.moveToElement(langLear).click().perform();
			WebElement filters=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"Filters\")]/parent::button")));
			a.moveToElement(filters).click().perform();
			WebElement language=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Language\"]/ancestor::button")));
			a.moveToElement(language).click().perform();
			List<WebElement> languages=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"css-o7qqao\"]")));
			System.out.println(languages.size());
			for(WebElement x:languages) {
				a.moveToElement(x).click().perform();
				WebElement Level=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Level']/ancestor::button")));
				a.moveToElement(Level).click().perform();
				WebElement beg=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Beginner\"]/child::span")));
				System.out.println(beg.getText());
				WebElement inter=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()=\"Intermediate\"]/child::span")));
				System.out.println(inter.getText());
				WebElement adv=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()=\"Advanced\"]/child::span")));
				System.out.println(adv.getText());
				WebElement mix=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()=\"Mixed\"]/child::span")));
				System.out.println(mix.getText());
				
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
	
	


