import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class RSAcademyLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("nehadewangan88@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Neha@1988");
		driver.findElement(By.id("login")).click();
		driver.switchTo().alert().sendKeys(Keys.chord(Keys.ENTER));

	}

}
