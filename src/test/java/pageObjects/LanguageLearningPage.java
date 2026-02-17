package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class LanguageLearningPage extends BasePage {
	
	public LanguageLearningPage(WebDriver driver) {
		super(driver);
	}
 
	@FindBy(xpath="//button[@class='cds-149 cds-button-disableElevation cds-button-ghost css-2bhpsm']")
	WebElement showMorebtn;
	
	@FindBy(xpath = "//div[contains(@data-testid,'language')]")
	List<WebElement> languages;
	
	@FindBy(xpath="//div[contains(@data-testid,'productDifficultyLevel')]")
	List<WebElement> levels;
	
	public void showAllLanguages() {
		click(showMorebtn);
		System.out.println("ClickedDone");
	}
	
	public void captureLanguages() throws IOException {
		
		
		System.out.println("size= "+languages.size());
		ExcelUtility e2=new ExcelUtility(System.getProperty("user.dir")+"\\LangandCount.xlsx");
		e2.setCellData("Sheet1", 0, 0,"Language" );
		e2.setCellData("Sheet1", 0, 1,"Total No Of courses" );
		int ruth=1;
		for(WebElement w:languages) {
			//System.out.println(w.getText());
			String text=w.getText();
			String lang=text.substring(0, text.indexOf("("));
			String count=text.substring(text.indexOf("(")+1, text.indexOf(")"));
			System.out.println(lang+" : "+ count);
			e2.setCellData("Sheet1", ruth, 0, lang);
			e2.setCellData("Sheet1", ruth, 1, count);
			ruth++;
		}
		
		
	}
	
	public void captureLevels() throws IOException {
		
	System.out.println("size= "+levels.size());
	
	
	ExcelUtility e2=new ExcelUtility(System.getProperty("user.dir")+"\\LangandCount.xlsx");
	e2.setCellData("Sheet1", 0, 2,"Level NAme" );
	e2.setCellData("Sheet1", 0, 3,"Total No Of courses" );
	int j=1;
		for(WebElement l:levels) {
			//System.out.println(l.getText());
			
			String text=l.getText();
			String lev=text.substring(0,text.indexOf("("));
			String count=text.substring(text.indexOf("(")+1, text.indexOf(")"));
			
			System.out.println(lev+" : "+count);
			e2.setCellData("Sheet1", j, 2,lev );
			e2.setCellData("Sheet1", j, 3,count);
			j++;
		}
	
	
	}

}
