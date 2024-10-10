package Practice2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Hostel {
	
	@Test
	public void SeniorHostel()
	{
		System.out.println("SeniorHostel");
	}
	
	@Test
	public void JuniorHostel()
	{
		System.out.println("JuniorHostel");
	}
	
	@AfterTest
	public void ClosingHours()
	{
		System.out.println("Hostel entries are not allowed after closing hours!!");
	}
	
	
}

