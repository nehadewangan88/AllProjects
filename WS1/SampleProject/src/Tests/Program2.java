import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program2 {

	@Test
	public void Test1()
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https:www.gmail.com");
		driver.close();
	}

}
