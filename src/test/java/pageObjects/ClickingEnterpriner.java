package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class ClickingEnterpriner extends BasePage{
	
	public ClickingEnterpriner(WebDriver driver) {

        super(driver);
	}
	
	@FindBy(xpath="//a[text()='For Enterprise']")
	WebElement Enterprise;
	
	 public void clickEntrepreniur() {

         click(Enterprise);
	    }

}
