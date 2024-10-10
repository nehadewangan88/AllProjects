import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.*;
public class Program1 {

	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https:www.gmail.com");
		driver.close();
	}
}
