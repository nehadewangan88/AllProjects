import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Profile']"))).build().perform();
		act.moveToElement(driver.findElement(By.xpath("//div/a[text()='login / Signup']"))).click().build().perform();
		driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("9538829712");
		driver.findElement(By.xpath("//div[text()='CONTINUE']")).click();
		driver.findElement(By.xpath("//span[text()=' Password ']")).click();
		driver.findElement(By.xpath("//span[text()='Password']")).sendKeys("DinaDisa@2021");
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		Thread.sleep(Duration.ofSeconds(30));
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))).click().build().perform();
		act.keyDown(Keys.SHIFT).sendKeys("Caprese Laptop Handbags").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//div/picture/img[@title='Caprese Floral Printed Oversized Structured Handheld Bag']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator <String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		String price = driver.findElement(By.xpath("//span[@class='pdp-price']/strong")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		List<WebElement> itemList = new ArrayList<WebElement>();
		int countOfElements = driver.findElements(By.xpath("//ul[@class='index-wishListContainer']/div[@class='itemcard-itemCard']")).size();
		for (int i=0;i<countOfElements;i++)
		{
			WebElement item = driver.findElement(By.xpath("//ul[@class='index-wishListContainer']/div[1]/div[@class='itemcard-itemActions']/div/p[@class='itemdetails-itemDetailsLabel']"));
			String itemName = item.getText();
			System.out.println(itemName);
			itemList.add(item);
			
		}
		System.out.println(itemList);
		
	}

}
