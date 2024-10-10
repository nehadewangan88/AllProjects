import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		/*
		 * driver.findElement(By.xpath("//button[text()='Login/ Sign Up']")).click();
		 * driver.findElement(By.
		 * xpath("//input[@placeholder='Enter Phone number/ Email Id']")).sendKeys(
		 * "9538829712");
		 * driver.findElement(By.xpath("//button[text()='Continue']")).click();
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[text()='Verify & Continue']")));
		 * driver.findElement(By.xpath("//button[text()='Verify & Continue']")).click();
		 */
		driver.findElement(By.xpath("(//button[contains(@id,'headlessui-menu-button-:')]/*[contains(@class,'CategoryMenu___StyledArrowDown')])[2]")).click();
		Actions action = new Actions(driver);
	//	wait.until(ExpectedConditions.titleContains("Fruits And Vegetables: Buy Fruits And Vegetables Online at Our Online Vegetable Store at great price  - bigbasket"));
		action.moveToElement(driver.findElement(By.xpath("(//li/a[@class='CategoryTree___StyledLink-sc-8wbym9-0 gTvqBK' and text()='Fruits & Vegetables'])[2]"))).click().perform();
		driver.findElement(By.xpath("//div[@class='p-2.5 pt-0 flex flex-col bg-white border border-silverSurfer-200 shadow-3 rounded-2xs h-full']/*[text()='Show more +']")).click();
		//List<WebElement> fruitsandvegs = driver.findElements(By.xpath("//div[@class='p-2.5 pt-0 flex flex-col bg-white border border-silverSurfer-200 shadow-3 rounded-2xs h-full']/ul/li"));
		//WebElement herbs = fruitsandvegs.stream().filter(types->types.findElement(By.xpath("//div[@class='p-2.5 pt-0 flex flex-col bg-white border border-silverSurfer-200 shadow-3 rounded-2xs h-full']/ul/li"))
		//	.getText().equals("Herbs & Seasonings")).findFirst().orElse(null);
		driver.findElement(By.xpath("//div[@class='p-2.5 pt-0 flex flex-col bg-white border border-silverSurfer-200 shadow-3 rounded-2xs h-full']/ul/li/a[text()='Herbs & Seasonings']")).click();
		
		List<WebElement> herbsList = driver.findElements(By.xpath("//li[@class='PaginateItems___StyledLi-sc-1yrbjdr-0 dDBqny']"));
		WebElement one = driver.findElement(By.xpath("//li[@class='PaginateItems___StyledLi-sc-1yrbjdr-0 dDBqny']/*//h3"));
		
		WebElement herb = herbsList.stream().filter(item->one.getText().equals("Garlic - Peeled")).findFirst().orElse(null);
		herb.findElement(By.xpath("//button[text()='Add']")).click();
		
	}

}
