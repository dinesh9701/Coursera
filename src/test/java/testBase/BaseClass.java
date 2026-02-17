package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;


public class BaseClass {
	public Logger logger;
	public static WebDriver driver;
	public Properties p;
	@Parameters({"os","browser"})
	
	@BeforeClass
	public void setUp(@Optional("Windows") String os,@Optional("chrome") String br)throws Exception {
		logger= LogManager.getLogger(this.getClass());
		
		FileReader file=new FileReader("C:\\Users\\2462034\\OneDrive - Cognizant\\Documents\\Autmationmajor\\MajorProject\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
	switch(br.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}
		
		driver.get(p.getProperty("appUrl"));

		driver.manage().window().maximize();
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
