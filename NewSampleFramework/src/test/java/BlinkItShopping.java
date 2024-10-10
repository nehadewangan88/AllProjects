import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;


public class BlinkItShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.blinkit.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='animationText-3']")).sendKeys("Wheat");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Whole ']"))).click().perform();
		

	}

}
