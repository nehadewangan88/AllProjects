package Application.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Application.AbstractComponents.AbstractClass;

public class DashboardPage extends AbstractClass{
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement PIMLink;
	
	public PIMPage goToPIMPage(String url)
	{
		PIMLink.click();
		waitForUrlToLoad(url);
		return new PIMPage(driver); 
	}

}
