package Application.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	public AbstractClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForUrlToLoad(String url)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlMatches(url));
	}

	
}
