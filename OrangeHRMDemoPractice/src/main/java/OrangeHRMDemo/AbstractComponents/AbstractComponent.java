package OrangeHRMDemo.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForURLMatch(String url)
	{
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlMatches(url));
		
	}
}
