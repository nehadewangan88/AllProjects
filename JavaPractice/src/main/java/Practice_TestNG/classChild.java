package Practice_TestNG;

public class classChild  extends classParent{
	
	public void method1()
	{
		System.out.println("Inside Child Method1");
		int i=30;
		int j =40;
		int k=i+j;
		System.out.print(k);
		
	}
	
	public static void main(String args[])
	{
		classChild classchild = new classChild();
		classParent classparent = new classParent();
		
		classchild.method1();
		classparent.method1();
		classParent.method1();
		
		
		
	}
	
	

}
