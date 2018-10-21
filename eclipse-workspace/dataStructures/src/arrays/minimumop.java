
package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class minimumop {
	
	
	static int converttozero(int [] arr, int length)
	{
		int count=0;
		int zeroarray[]=arr;
		for(int i=0;i<length;i++)
		{
			if(zeroarray[i]!=0)
			{
				zeroarray[i]=0;
				count++;
			}
			
		}
		System.out.println("Zero Array:"+java.util.Arrays.toString(zeroarray));
		return count;
		
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the length of the array:");
		int length=Integer.parseInt(br.readLine());
		int numarr[] = new int[length];
		System.out.println("Enter the array elements");

		for(int i=0;i<length;i++) {
			System.out.print("Array["+i+"]");
			numarr[i]=Integer.parseInt(br.readLine());
		}
		int count=converttozero(numarr,length);
		System.out.println("Minimum operations taken:" +count);
		
	}

}
