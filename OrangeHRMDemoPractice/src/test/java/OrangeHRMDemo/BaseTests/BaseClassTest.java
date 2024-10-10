package OrangeHRMDemo.BaseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import OrangeHRMDemo.PageObjects.LoginPage;

public class BaseClassTest {

	public WebDriver driver;
	public LoginPage loginPage;
	public WebDriver initializeDriver() throws IOException
	{
		Properties property = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\OrangeHRMDemo\\Utilities\\Global.properties");
		property.load(fileInputStream);
		String browserName = property.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome"))
		{
		//	WebDriverManager.chromedriver.setup();
			driver = new ChromeDriver();
			
			LoginPage loginPage = new LoginPage(driver);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.out.println("Firefox Browser!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		return driver;
	}
	
	@BeforeMethod
	public LoginPage launchOrangeHRMDemoApplication() throws IOException
	{
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.openOrangeHRMApplication();
		return loginPage;
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
}
