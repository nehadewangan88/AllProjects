package OrangeHRMDemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRMDemo.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginButton;
	
	public void openOrangeHRMApplication()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public DashboardPage loginToOrangeHRM(String username, String pwd) {
		// TODO Auto-generated method stub
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		return new DashboardPage(driver);
	}
}
