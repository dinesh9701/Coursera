package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CoursesPage extends BasePage{
	
	
	public CoursesPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Filter button For Language dropdown
	
	@FindBy(xpath="//div[text()='Language']")
	WebElement languageFilter;
	
	
	//finding for Selecting english option
	@FindBy(xpath="//span[text()='English']/ancestor::div[1]/preceding-sibling::span")
	WebElement english;
	
	//xpath for view button 
	@FindBy(xpath="//span[text()='View']/parent::button")
	WebElement view;
	
	//xpath for Filter Level
	@FindBy(xpath="//div[text()='Level']")
	WebElement level;
	
	//xpath for Beginner Level
	@FindBy(xpath="//span[text()='Beginner']/ancestor::div[1]/preceding-sibling::span")
	WebElement begineerLevel;
	
	//Courses List
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/preceding-sibling::ul/li")
	List<WebElement> coursesList;
	
	//RatingList
	@FindBy(xpath="//div[contains(text(),'Rating')]")
	List<WebElement> ratingList;
	//Methods or actions for clicking or selecting
	
	//clicking language
	public void clickLanguage() {
		click(languageFilter);
	}
	public void selectEnglish() {
		actionClick(english);
	}
	
	public void clickView() {
		actionClick(view);
	}
	
	public void clickLevel() {
		click(level);
	}
	
	public void selectBeginerLevel() {
		actionClick(begineerLevel);
	}
	
	public void Waiting() {
		waitOfAllVisibility(ratingList);
	}
	public List<WebElement> Waiting2() {
		waitOfAllVisibility(coursesList);
		return coursesList;
	}
	
	public void RatingsOfAllCards(int n) {
//		System.out.println(ratingList.size());
//		System.out.println(coursesList.size());
	
		int i=1;
		for(WebElement x: ratingList) {
				if(i<=n) {
					System.out.println(getText(x));
					i++;
				}
				else {
					break;
				}
		}
	}
	
	

}
