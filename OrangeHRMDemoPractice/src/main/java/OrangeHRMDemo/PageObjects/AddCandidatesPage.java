package OrangeHRMDemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRMDemo.AbstractComponents.AbstractComponent;

public class AddCandidatesPage extends AbstractComponent{
	
	WebDriver driver;
	
	public AddCandidatesPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="middleName")
	WebElement middleName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//label[text()='Email']/../../div/input[@placeholder='Type here']")
	WebElement email;
	
	@FindBy(xpath="//label[text()='Contact Number']/../../div/input[@placeholder='Type here']")
	WebElement contactNumber;
	
	@FindBy(xpath="//label[text()='Keywords']/../../div/input[@placeholder='Enter comma seperated words...']")
	WebElement keywords;
	
	@FindBy(xpath="//label[text()='Notes']/../../div/textarea[@placeholder='Type here']")
	WebElement notes;
	
	@FindBy(xpath="//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']/i")
	WebElement concent;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	public void addNewCandidate(String fName,String mName,String lName,String emailId,String mobNumber,String skills,String profileNotes,String url)
	{
		
		firstName.sendKeys(fName);
		middleName.sendKeys(mName);
		lastName.sendKeys(lName);
		email.sendKeys(emailId);
		contactNumber.sendKeys(mobNumber);
		keywords.sendKeys(skills);
		notes.sendKeys(profileNotes);
		concent.click();
		saveButton.click();
		waitForURLMatch(url);
		
	}

	
	
	
	
	
}
