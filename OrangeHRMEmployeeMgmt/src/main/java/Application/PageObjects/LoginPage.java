package Application.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Application.AbstractComponents.AbstractClass;

public class LoginPage extends AbstractClass{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(name="username")
	WebElement userNameTextBox;
	
	@FindBy(name="password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginButton;
	
	public void openOrangeApplicationHRM(String url)
	{
		driver.get(url);
	}

	public DashboardPage loginToOrangeHRM(String usrname, String pwd, String url)
	{
		userNameTextBox.sendKeys(usrname);
		passwordTextBox.sendKeys(pwd);
		loginButton.click();
		waitForUrlToLoad(url);
		return new DashboardPage(driver);
	}
}
