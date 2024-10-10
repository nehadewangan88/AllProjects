import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import OrangeHRM.pageobjects.AddJob;
import OrangeHRM.pageobjects.LandingPage;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.time.Duration;
import java.util.*;
public class OrangeHRMAddJobs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
	//	Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		
		// reuse.DefineAction();
		LandingPage landingPage = new LandingPage(driver);
		AddJob addJob = new AddJob(driver);
		landingPage.GoToURL();
		landingPage.LoginToOrangeHRM("Admin", "admin123");
		addJob.navigateToJobLists("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList", By.xpath("//a[text()='Job Titles']"));
		//addJob.addJobTitle();
		
		
		
		
		
		List<WebElement> jobTitles = driver.findElements(By.xpath("//div[@class='orangehrm-container']"));
		WebElement jobTitle = jobTitles.stream().filter(title->title.findElement(By.xpath("//div[text()='Job Titles']/following-sibling::div")).getText().equals("Associate System Engineer")).findAny().orElse(null);
		if (jobTitle== null)
		{
			System.out.print("Title is Null!!");
			addJob.addNewJobTitle("Associate System Engineer", "Associate System Engineer", "Added ASE");
			
		}
		else		
			jobTitle.findElement(By.xpath("//div[text()='James Butler']/../../../../div[@class='card-item card-header-slot-content --right']//i[@class='oxd-icon bi-trash']")).click();
		
	}

}
