package OrangeHRMDemo.PageObjects;

import org.openqa.selenium.WebDriver;

import OrangeHRMDemo.AbstractComponents.AbstractComponent;

public class DashboardPage extends AbstractComponent{

	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RecruitmentPage succesfulLogin(String dashboardPageUrl)
	{
		waitForURLMatch(dashboardPageUrl);
		return new RecruitmentPage(driver);
	}

}
