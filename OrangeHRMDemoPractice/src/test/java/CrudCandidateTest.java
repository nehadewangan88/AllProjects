import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OrangeHRMDemo.BaseTests.BaseClassTest;
import OrangeHRMDemo.PageObjects.AddCandidatesPage;
import OrangeHRMDemo.PageObjects.DashboardPage;
import OrangeHRMDemo.PageObjects.LoginPage;
import OrangeHRMDemo.PageObjects.RecruitmentPage;

public class CrudCandidateTest extends BaseClassTest{

	@Test(dataProvider="getData")
//	public void LoginToOrangeHRMApp(String FName,String MName,String LName,String Email,String Mob,String Course, String Notes) throws IOException
	//Hashmap code
	public void LoginToOrangeHRMApp(HashMap<String,String> input)
			{
		
		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 */
		//LoginPage loginPage = new LoginPage(driver);
		//loginPage.loginToOrangeHRM("Admin", "admin123");
		
		//loginPage.openOrangeHRMApplication();
	//	LoginPage loginPage = launchOrangeHRMDemoApplication();
		DashboardPage dashboardPage = loginPage.loginToOrangeHRM("Admin", "admin123");
		RecruitmentPage recruitmentPage = dashboardPage.succesfulLogin("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		//RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
		AddCandidatesPage addCandidates = recruitmentPage.navigateToRecruitmentPage();
	//	AddCandidatesPage addCandidates = new AddCandidatesPage(driver);
	//	addCandidates.addNewCandidate(FName,MName,LName,Email,Mob,Course,Notes,"https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate/*");
		//Hashmap code
		addCandidates.addNewCandidate(input.get("firstName"),input.get("middleName"),input.get("lastName"),input.get("email"),input.get("mobileNo"),input.get("course"),input.get("comments"), input.get("url"));
		recruitmentPage.openCandidatesList();
		recruitmentPage.viewCandidateDetails();
		recruitmentPage.editCandidateDetails();
	//	recruitmentPage.deleteCandidateRecord("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
		
		/*
		 * Thread.sleep(1000); WebElement successText = driver.findElement(By.xpath(
		 * "//div[text()='Description']/../div[@class='data']"));
		 * assert(successText.getText().contains("user added Somit Raj Mathur"));
		 */
	}

	/*
	 * @DataProvider public Object[][] getData() { return new Object[][] {{"Rahul",
	 * "Raj", "Verma","rahulraj@gmail.com","+916789934517",
	 * "Java,Selenium,Appium","New QA Automation Profile"},{"Hem", "Singh",
	 * "Mehra","hemsingh@gmail.com","+919900934517",
	 * "Java,Selenium,Appium","New QA Automation Profile"},{"Josh", "Benn",
	 * "Will","joshwill@gmail.com","+916710934517",
	 * "Java,Selenium,Appium","New QA Automation Profile"}}; }
	 */
	
	//HashMap Code
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<Object,Object> map = new HashMap<Object,Object>();
		map.put("firstName", "Rahul");
		map.put("middleName", "Raj");
		map.put("lastName", "Verma");
		map.put("email", "rahulraj@gmail.com");
		map.put("mobileNo", "+916789934517");
		map.put("course", "Java,Selenium,Appium");
		map.put("comments", "New QA Automation Profile");
		map.put("url", "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate/*");
		
		HashMap<Object,Object> map1 = new HashMap<Object,Object>();
		map1.put("firstName", "Hemant");
		map1.put("middleName", "Raj");
		map1.put("lastName", "Verma");
		map1.put("email", "hemantraj@gmail.com");
		map1.put("mobileNo", "+916789890517");
		map1.put("course", "Java,Selenium,Appium");
		map1.put("comments", "New QA Automation Profile");
		map.put("url", "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate/*");
		
		return new Object[][] {{map},{map1}};
		
		
	}
}
