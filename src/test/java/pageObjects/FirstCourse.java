package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class FirstCourse extends BasePage{
	
	List<WebElement>e1=new ArrayList<>();
	String main;
	public FirstCourse(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1")
	WebElement name;
	
	@FindBy(xpath="//span[contains(text(),'hours')]")
	List<WebElement> hours;
	
	
	public void ListOfCourses() {
		CoursesPage cp=new CoursesPage(driver);
		e1= cp.Waiting2();
	}
	public String MainWindow() {
	main=driver.getWindowHandle();
//	driver.switchTo().window(main);
	return main;
	}
	public void clickCourses() throws IOException {
		ListOfCourses();
		String m=MainWindow();
		int j=1;
		ExcelUtility e2=new ExcelUtility(System.getProperty("user.dir")+"\\testData.xlsx");
		e2.setCellData("Sheet1", 0, 0,"CourseName" );
		e2.setCellData("Sheet1", 0, 1,"Total No Of Hours" );
		e2.setCellData("Sheet1", 0, 2, "Rating");
		
		for(int i=0;i<2;i++) {
			WebElement temp=e1.get(i);
			click(temp);
			switchWindow();
			System.out.println( Name());
			String courseTitle=Name();
			System.out.println("Total NoOf Hours" + NoOfHours()+" H");
			String totalHours=""+NoOfHours();
			e2.setCellData("Sheet1", j, 0, courseTitle);
			e2.setCellData("Sheet1", j, 1,totalHours );
//			e2.setCellData("Sheet1", j, 1,a[i]);
			j++;
			driver.close();
			driver.switchTo().window(m);
		}
		}
	
	
	//product Exce
	
	public String Name() {
		return getText(name);
	}
	
	public int NoOfHours() {
		waitOfAllVisibility(hours);
		int total=0;
		for(WebElement x: hours) {
			String s=x.getText();
			char c=s.charAt(0);
			int n=c-'0';
			total+=n;
			System.out.println(x.getText());
			
		}
		return total;
	}
	
	public void switchWindow() {
		
	int i=0;
	Set<String>s1=driver.getWindowHandles();

	for(String x:s1) {
		
//		System.out.println(x);
		if(i==1) {
			driver.switchTo().window(x);
		}
		i++;
	}
	}
}
