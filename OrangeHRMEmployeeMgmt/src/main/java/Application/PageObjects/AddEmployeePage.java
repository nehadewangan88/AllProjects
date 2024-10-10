package Application.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Application.AbstractComponents.AbstractClass;

public class AddEmployeePage extends AbstractClass{
	
	WebDriver driver;
	public AddEmployeePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstName")
	WebElement firstNameTextBox;
	
	@FindBy(name="middleName")
	WebElement middleNameTextBox;
	
	@FindBy(name="lastName")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	public void saveEmployeeDetails(String fName, String mName,String lName,String url)
	{
		firstNameTextBox.sendKeys(fName);
		middleNameTextBox.sendKeys(mName);
		lastNameTextBox.sendKeys(lName);
		saveButton.click();
		waitForUrlToLoad(url);
	}

}

