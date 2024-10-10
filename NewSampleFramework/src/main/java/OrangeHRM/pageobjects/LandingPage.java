package OrangeHRM.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.AbstractComponents.AbstractClass;

public class LandingPage extends AbstractClass{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement login;
	
	public void GoToURL()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void LoginToOrangeHRM(String name, String pwd)
	{
		userName.sendKeys(name);
		password.sendKeys(pwd);
		login.click();
	}
	
	

}
