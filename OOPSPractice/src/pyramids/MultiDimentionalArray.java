package pyramids;

public class MultiDimentionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[][] = new int[2][3];
		a[0][0]=10;
		a[0][1]=20;
		a[0][2]=30;
		a[1][0]=40;
		a[1][1]=5;
		a[1][2]=6;
		int min=a[0][0];
		int j=0;
		int k=0;
		
		for (j=0;j<2;j++)
		{
			for(k=0;k<3;k++)
			{
				if(a[j][k]<min)
				{
					min = a[j][k];
				}
				else
					min = min;
				System.out.print(a[j][k]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("Minimum number is:"+min);	
		for (j=0;j<2;j++)
		{
			for(k=0;k<3;k++)
			{
				if(a[j][k]==min)
				{
					System.out.println(j+" "+k);
				}
				
				
			}
		}
	}

}
