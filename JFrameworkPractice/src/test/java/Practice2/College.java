package Practice2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class College {
	
	@Test
	public void MechanicalBranch()
	{
		System.out.println("MechanicalBranch");
	}
	
	@Test
	public void CivilBranch()
	{
		System.out.println("CivilBranch");
	}
	
	@Test
	public void BranchITBranch1()
	{
		System.out.println("Branch-ITBranch");
	}
	
	@Test
	public void BranchITBranch2()
	{
		System.out.println("Branch-ITBranch2");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("Executes after every college method!!!");
	}
	
	@Test
	public void ITBranch3()
	{
		System.out.println("ITBranch3");
		Assert.assertTrue(false);
	}
	
	@Test
	public void BranchITBranch4()
	{
		System.out.println("Branch-ITBranch4");
		Assert.assertTrue(false);
		
	}
	
	@Test(dependsOnMethods= {"NewBranch"})
	public void ITBranch5()
	{
		System.out.println("ITBranch5");
	}
	
	@Test
	public void NewBranch()
	{
		System.out.println("New Branch");
	}
	
	@BeforeSuite
	public void BirthCertificate()
	{
		System.out.println("Birth Certificate is mandatory before all process!!!");
	}
	
}

