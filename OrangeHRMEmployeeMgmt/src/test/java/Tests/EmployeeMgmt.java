package Tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Application.PageObjects.AddEmployeePage;
import Application.PageObjects.DashboardPage;
import Application.PageObjects.LoginPage;
import Application.PageObjects.PIMPage;


public class EmployeeMgmt {

	@Test(dataProvider="getData")
	public void EmployeeAddition(HashMap<String,String> input)
	{
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openOrangeApplicationHRM("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		DashboardPage dashboardPage = loginPage.loginToOrangeHRM("Admin", "admin123","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		PIMPage pimPage = dashboardPage.goToPIMPage("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		AddEmployeePage addEmployeePage = pimPage.addEmployee("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		addEmployeePage.saveEmployeeDetails(input.get("firstName"), input.get("middleName"), input.get("lastName"),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/*");
		String empID = driver.findElement(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input")).getText();
		System.out.println(empID);
		driver.close();
		
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<Object,Object> data1 = new HashMap<Object,Object>();
		data1.put("firstName", "Hailey");
		data1.put("middleName", "Bill");
		data1.put("lastName", "Wilson");
		
		HashMap<Object,Object> data2 = new HashMap<Object,Object>();
		data2.put("firstName", "Justin");
		data2.put("middleName", "Tim");
		data2.put("lastName", "Johnathan");
		
		return new Object[][] {{data1},{data2}};
		
	}

}
