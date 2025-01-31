import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cleartrip {

	public static void main(String[] args) throws InterruptedException {
		 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize(); 
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='px-1   flex flex-middle nmx-1 pb-1']")).click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Search flights']")));
		selectTrip(driver,act);
	//	Thread.sleep(Duration.ofSeconds(5));
		addAdults(driver);
		selectDepartureDate(driver,act,wait);
		Thread.sleep(Duration.ofSeconds(10));
		driver.close();
	}
	
	public static void selectTrip(WebDriver driver, Actions act)
	{
		WebElement tripSelection = driver.findElement(By.xpath("//span[text()='Round trip' or text()='One way']"));
		tripSelection.click();
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Round trip']"))).click().build().perform();
	}
	
	public static void addAdults(WebDriver driver)
	{
		WebElement adultSelection = driver.findElement(By.xpath("//button/div/div/span[text()='1 Adult, Economy']"));
		adultSelection.click();
		WebElement adultCount = driver.findElement(By.xpath("//div[@class='ls-reset br-4 w-100p px-2 dropdown__item c-neutral-900 flex flex-between flex-middle px-4']/div/span[text()='Adults']/../../ul/li[3]"));
		for (int i=1; i<5; i++)
			{
				adultCount.click();
			}
		adultSelection.click();
	}
	
	public static void selectDepartureDate(WebDriver driver,Actions act, WebDriverWait wait)
	{
		WebElement departure = driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']/button[1]"));
		departure.click();
		String currentMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']/div")).getText();
	//	System.out.println(currentMonthYear);	
		String expectedMonth = "March 2025";
		while(currentMonthYear!=expectedMonth)
		{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/*[@data-testid='rightArrow']")));
			//	WebElement forwardButton = driver.findElement(By.xpath("//div/*[@data-testid='rightArrow']"));
				act.moveToElement(driver.findElement(By.xpath("//div/*[@data-testid='rightArrow']"))).click().build().perform();
				currentMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']/div")).getText();
				System.out.println(currentMonthYear);
			
		}
	}

}
