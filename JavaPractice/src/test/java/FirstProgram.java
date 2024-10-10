import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {

	public static void main(String[] args) throws InterruptedException {
	
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "/Users/nehad/eclipse-workspace/JavaPractice/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5);
		driver.switchTo().frame("//form[@class='oxd-form']");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
	}

}
