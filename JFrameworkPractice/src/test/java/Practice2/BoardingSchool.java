package Practice2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoardingSchool {
	
	@Test(dataProvider="getData")
	public void Classes(String classNo, String section)
	{
		System.out.println(classNo);
		System.out.println(section);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		data[0][0]="Class-1";
		data[0][1]="Section-A";
		data[1][0]="Class-2";
		data[1][1]="Section-B";
		data[2][0]="Class-3";
		data[2][1]="Section-A";
		return data;
	}
}
