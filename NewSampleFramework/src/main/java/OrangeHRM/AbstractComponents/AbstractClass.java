package OrangeHRM.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractClass(WebDriver driver)
	{
		this.driver = driver;
		
		
	}
	
	public void waitForURLMatch(String url)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlMatches(url));
		//"https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"));
				
	}
	
	public void moveToDesiredElement(By findByLocator)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(findByLocator)).click().perform();
		
	}

}
