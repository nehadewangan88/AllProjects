import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PracticeActions {

	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.irctc.co.in");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath("//img[@id='disha-banner-close']")).click();
//		WebElement menuOptions = driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']"));
//		menuOptions.click();
//		Actions action = new Actions(driver);
//		WebElement Trains = driver.findElement(By.xpath("//label[@class='toggle']/span/*[text()='TRAINS']"));
//		action.moveToElement(Trains).click().perform();
//		WebElement irctcTrains = driver.findElement(By.xpath("//label[@class='toggle']/span[text()='IRCTC TRAINS']"));
//		action.moveToElement(irctcTrains).build().perform();
//		WebElement groupBooking = driver.findElement(By.xpath("//label[@class='toggle']/span[text()='IRCTC TRAINS']/../..//*/span[text()='Group Booking']"));
//		action.moveToElement(groupBooking).click().perform();
//		Set<String>windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		String parentID = it.next();
//		String childID = it.next();
//		driver.switchTo().window(childID);
//		driver.findElement(By.xpath("//a[text()=' Proceed for Group booking']")).click();
//		driver.findElement(By.xpath("//li[@class='nav-item dropdown d-none d-md-block']/a[text()='Contact Us']")).click();
//		WebElement emailID = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[@href='mailto:tourism@irctc.com']"));
//		action.moveToElement(emailID).build().perform();
//		String id = emailID.getText();
//		System.out.println(id);
//		String id1 = id.replace("[at]", "@");
//		String id2 = id1.replace("[dot]", ".");
//		System.out.println(id2);  
		driver.get("https://www.makemytrip.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Introducing myBiz']"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//p[text()='SWITCH TO MYBIZ']"))).click().perform();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Sign in with Google Button']")));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[text()='Continue with Google']")));
		driver.findElement(By.xpath("//div/span[text()='Continue with Google']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String mainWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//div[text()='Use another account']")).click();
		driver.close();
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
	}
}
