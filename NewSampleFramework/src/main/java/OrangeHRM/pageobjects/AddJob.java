package OrangeHRM.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.AbstractComponents.AbstractClass;

public class AddJob extends AbstractClass {
	
	WebDriver driver;
	
	public AddJob(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminLink;
	
	@FindBy(xpath="//span[text()='Job ']")
	WebElement jobLink;
	
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	
	@FindBy(xpath="//label[text()='Job Title']/../following-sibling::div/input")
	WebElement jobTitle;
	
	@FindBy(xpath="//label[text()='Job Description']/../following-sibling::div/textarea")
	WebElement jobDescription;
	
	@FindBy(xpath="//label[text()='Note']/../following-sibling::div/textarea")
	WebElement note;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
			
	
	public void navigateToJobLists(String expectedURL, By elementLocator)
	{
		adminLink.click();
		jobLink.click();
		moveToDesiredElement(elementLocator);
		waitForURLMatch(expectedURL);
	}
	public void addNewJobTitle(String newJobTitle, String jobDesc, String jobNote)
	{
		addButton.click();
		jobTitle.sendKeys(newJobTitle);
		jobDescription.sendKeys(jobDesc);
		note.sendKeys(jobNote);
		saveButton.click();
	}
	

}
