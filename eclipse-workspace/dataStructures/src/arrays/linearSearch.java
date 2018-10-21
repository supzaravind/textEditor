package arrays;
// Linear search 
//Time complexity : O(n)  n=size of array
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class linearSearch {
	
	public static void getIndex(int findnum, int[] srcarray,int len)
	{
		int myarray[]=srcarray;
		int count=0;
		for(int i=0;i<len;i++)
		{
			if(myarray[i]==findnum)
			{
				System.out.println("Element "+findnum+" is at the positon"+i);
				count=count+1;
			}
			
		}
		if(count==0)
		{
			System.out.println("Element not found");
		}
		
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Enter the length of the array");
		int length=Integer.parseInt(br.readLine());
		int [] arr = new int[length];
		System.out.println("Enter the array elements");
		for(int i=0;i<length;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("Enter the element to be found");
		int searchnum=Integer.parseInt(br.readLine());
		getIndex(searchnum,arr,length);
		
	}
}
