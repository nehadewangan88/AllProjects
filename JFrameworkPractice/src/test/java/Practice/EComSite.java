package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EComSite {

	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		WebElement userRoleDropDown = driver.findElement(By.xpath("//label[text()='User Role']/../../*//div[text()='-- Select --']"));
		userRoleDropDown.click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Admin']"))).click();
		
		
		
	}
}
