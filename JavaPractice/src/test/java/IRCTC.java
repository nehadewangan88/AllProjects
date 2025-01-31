import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//input[@class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("Durg");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' DURG - DURG ']")));
		WebElement origin = driver.findElement(By.xpath("//span[text()=' DURG - DURG ']"));
		act.moveToElement(origin).click().build().perform();
		driver.findElement(By.xpath("//input[@class='ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("Nagpur");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' NAGPUR - NGP ']")));
		WebElement destination = driver.findElement(By.xpath("//span[text()=' NAGPUR - NGP ']"));
		act.moveToElement(destination).click().build().perform();
	    WebElement calender = driver.findElement(By.xpath("//span[@class='ng-tns-c58-29 ui-calendar']/input"));
	    calender.click();
		//act.moveToElement(calender).click().build().perform();
	//	driver.findElement(By.xpath("//span[@class='ng-tns-c58-29 ui-calendar']/input")).clear();
	//	calender.clear();
	//	driver.findElement(By.xpath("//span[@class='ng-tns-c58-29 ui-calendar']/input")).sendKeys("22/06/2024");
	//	act.keyDown(Keys.ENTER);
		
		
	}

}
