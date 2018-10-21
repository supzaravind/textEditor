package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class binarySearch {
	public static int getIndex(int findnum, int[] myarray, int low,int high)
	{
		int max=high;
		int min=low;
		
		if(high>=1)
		{
			
		
	int mid=(min + max)/2;
			if(myarray[mid]==findnum) {
			  System.out.println("Element found at position"+mid);
				return 1 ;
			}
			if(myarray[mid]>findnum)
			{
			   max=mid-1;
			   getIndex(findnum,myarray,min,max);
			}
			if(myarray[mid]<findnum)
			{
				min=mid+1;
			    getIndex(findnum,myarray,min,max);
			}
		}
		System.out.println("ELement not found");
		return -1;
		
	}

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
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
		int returnvalue=getIndex(searchnum,arr,0,length-1);
		

	}

}
