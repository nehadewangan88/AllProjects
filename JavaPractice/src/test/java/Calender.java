import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String date = "23";
		String month = "Sep";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='px-1   flex flex-middle nmx-1 pb-1']")).click();
		WebElement footer = driver.findElement(By.xpath("//div[@class='bg-neutral-0 o-hidden']"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		int totalLinks = footer.findElements(By.tagName("a")).size();
		System.out.println(totalLinks);
		String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
		for (int i=0;i<totalLinks;i++)
		{
			System.out.println(links.get(i).getAttribute("href"));
			System.out.println(links.get(i).getText());
		}
		
		
		
		
		
		

	}

}
