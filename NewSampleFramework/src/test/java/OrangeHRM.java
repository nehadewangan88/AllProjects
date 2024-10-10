import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		List<WebElement> employeeDetails = driver.findElements(By.xpath("//div[@class='oxd-table-body']"));
		WebElement employeeName = employeeDetails.stream().filter(name->name.findElement(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']/div[2]")).getText().equals("JamesButler")).findAny().orElse(null);
		if (employeeName== null)
		{
			System.out.print("Name is Null!!");
			driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		//			action.sendKeys(driver.findElement(By.xpath("//div/label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-text-input']")),"ESS").
			action.sendKeys(driver.findElement(By.xpath("//div/label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-text-input']")),Keys.ARROW_DOWN.ENTER).click().perform();
			//action.sendKeys(driver.findElement(By.xpath("//div/label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-text-input']")),Keys.ENTER).build().perform();
			
			action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),"James ").build().perform();
			Thread.sleep(Duration.ofSeconds(5));
			action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),Keys.ARROW_DOWN).build().perform();
			Thread.sleep(Duration.ofSeconds(5));
			action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),Keys.ENTER).build().perform();
			Thread.sleep(Duration.ofSeconds(5));
			action.sendKeys(driver.findElement(By.xpath("//div/label[text()='Status']/../following-sibling::div//div[@class='oxd-select-text-input']")),Keys.ARROW_DOWN).build().perform();
			Thread.sleep(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//div/label[text()='Status']/../following-sibling::div")).click();
			Thread.sleep(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input")).sendKeys("James123");
			Thread.sleep(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div/input")).sendKeys("James@123");
			Thread.sleep(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input")).sendKeys("James@123");
			Thread.sleep(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//button[text()=' Save ']")).click();
			
		}
		else		
		    employeeName.findElement(By.xpath("//div[text()='James Butler']/../../../../div[@class='card-item card-header-slot-content --right']//i[@class='oxd-icon bi-trash']")).click();
		
	}

}
