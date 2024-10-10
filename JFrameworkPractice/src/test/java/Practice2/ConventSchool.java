package Practice2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ConventSchool {
	
	@Parameters({"SchoolURL", "CollegeURL"})
	@Test
	public void PreprimarySchool(String school_url, String college_url)
	{
		System.out.println("Pre-primarySchool");
		System.out.println(school_url +" "+ college_url);
	}
	
	
	@Test
	public void PrimarySchool()
	{
		System.out.println("PrimarySchool");
		
	}

	@AfterSuite
	public void verification()
	{
		System.out.println("Cerification Verification is mandatory at the end of all the process!");
	}
	
	@AfterSuite
	public void MiddleSchool()
	{
		System.out.println("MiddleSchool");
	}

	@Parameters({"section"})
	@Test
	public void HighSchool(String sec)
	{
		System.out.println("HighSchool");
		System.out.println(sec);
	}
	
	@BeforeTest
	public void Documentation()
	{
		System.out.println("Documentation is required before schooling!!");
	}
	
	@BeforeMethod
	public void BeforeMEthod()
	{
		System.out.println("Executes before every method of convent school");
	}

}
