package OrangeHRMDemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import OrangeHRMDemo.AbstractComponents.AbstractComponent;

public class RecruitmentPage extends AbstractComponent{

	WebDriver driver;
	public RecruitmentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()='Recruitment']")
	WebElement recruitmentLink;
	

	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	
	@FindBy(xpath="//div[text()='Rahul Raj Verma']/../../div/div/button/i[@class='oxd-icon bi-eye-fill']")
	WebElement viewCandidate;
	
	@FindBy(xpath="//div[contains(text(),'Rahul') and contains(text(),'Verma')]/../../../../div/div/div/button/i[@class='oxd-icon bi-trash']")
	WebElement deleteCandidate;
	
	@FindBy(xpath="//label[text()='Edit']/span")
	WebElement editCandidate;
	
	@FindBy(name="middleName")
	WebElement middleName;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	@FindBy(xpath="//a[text()='Candidates']")
	WebElement candidatesLink;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	WebElement deleteButton;
	
	
	
	
	public AddCandidatesPage navigateToRecruitmentPage()
	{
		recruitmentLink.click();
		addButton.click();
		return new AddCandidatesPage(driver);
	}

	public void viewCandidateDetails()
	{
		viewCandidate.click();
		
	}
	
	public void editCandidateDetails()
	{
		editCandidate.click();
		middleName.clear();
		middleName.sendKeys("Ram");
		saveButton.click();
		openCandidatesList();
		
	}
	
	public void openCandidatesList()
	{
		candidatesLink.click();
	}
	
	public void deleteCandidateRecord(String viewCandidatesURL)
	{
		openCandidatesList();
		waitForURLMatch(viewCandidatesURL);
		deleteCandidate.click();
		deleteButton.click();
	}
}
