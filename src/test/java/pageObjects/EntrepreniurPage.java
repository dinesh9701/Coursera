package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntrepreniurPage extends BasePage {
	public EntrepreniurPage(WebDriver driver) {
		super(driver);
	}
//	@FindBy(xpath="//a[text()='For Enterprise']")
//	WebElement Enterprise;

	@FindBy(xpath="//input[@id='FirstName']")
	WebElement fname;

	@FindBy(xpath="//input[@id='LastName']")
	WebElement lname;

	@FindBy(xpath="//input[@id='Email']")
	WebElement email;

	@FindBy(xpath="//input[@id='Phone']")
	WebElement phone;

	@FindBy(xpath="//select[@id='rentalField9']")
	WebElement OrganizationType;

	@FindBy(xpath="//input[@id='Title']")
	WebElement jobTitle;

    @FindBy(xpath="//input[@id='Company']")
    WebElement companyName;

    @FindBy(xpath="//select[@id='Employee_Range__c']")
    WebElement empRange;

    @FindBy(xpath="//select[@id='Self_Reported_Needs__c']")
    WebElement describe;

    @FindBy(xpath="//select[@id='Country']")
    WebElement country;

    @FindBy(xpath="//select[@id='State']")
    WebElement state;

    @FindBy(tagName="textarea")
    WebElement userDescibe;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;
    
    @FindBy(xpath="//select[@id='Self_reported_employees_to_buy_for__c']")
    WebElement temp;
    

    public void enterDetails(String Fname,String Lname,String Email,String Phone,String title,String cName) throws Exception {
    	ClickingEnterpriner cep=new ClickingEnterpriner(driver);
    	cep.clickEntrepreniur();
    	type(fname,Fname);
    	type(lname,Lname);
    	type(email,Email);
    	type(phone,Phone);
    	SelecetDropDownByIndex(OrganizationType,1);
    	type(jobTitle,title);
    	type(companyName,cName);
    	SelecetDropDownByIndex(empRange,1);
    	SelecetDropDownByIndex(describe,1);
    	SelecetDropDownByIndex(temp,1);
    	SelecetDropDownByVisbilityOfText(country,"India");
    	SelecetDropDownByVisbilityOfText(state,"Telangana");
//    	type(userDescibe,"kwqnam,niulqg981qkpq;'.?SAkbjabjkzk");
    	actionClick(submit);
//    	Thread.sleep(5000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
//    	js.executeScript("arguments[0].scrollIntoView(true);", fname);
    	js.executeScript("window.scrollTo(0,3900);");
    	takeScrrenshot();
    	
    }





}
