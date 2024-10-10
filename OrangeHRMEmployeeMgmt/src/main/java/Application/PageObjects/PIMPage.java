package Application.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Application.AbstractComponents.AbstractClass;

public class PIMPage extends AbstractClass {
	
	WebDriver driver;

	public PIMPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	
	public AddEmployeePage addEmployee(String url)
	{
		addButton.click();
		waitForUrlToLoad(url);
		return new AddEmployeePage(driver);
	}
}
