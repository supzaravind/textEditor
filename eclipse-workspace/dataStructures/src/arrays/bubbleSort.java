package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bubbleSort {
public static int arraysort(int [] arr,int len)
{
	System.out.println("checkpoint2");
 int myarray[]=arr;
 int n=len;
 System.out.println("checkpoint3");

 
 System.out.print("Unsorted Array : "+java.util.Arrays.toString(myarray));
 for(int i=0;i<n-1;i++)
  for(int j=0;j<n-i-1;j++)
 {
	 if(myarray[j]>myarray[j+1])
	 {
		 System.out.println("loop"+i);
		 int buffer=myarray[j];
		 myarray[j]=myarray[j+1];
		 myarray[j+1]=buffer;
		 
	 }
	 
 }
 System.out.print("sorted Array : "+java.util.Arrays.toString(myarray));
 
	return -1;
}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the length of the array");
		int length=Integer.parseInt(br.readLine());
		int [] arr = new int[length];
		System.out.println("Enter the array elements");
		for(int i=0;i<length;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("checkpoint1");
		int statuscode=arraysort(arr,length);
		//if(statuscode<0)
		//{
		//	System.out.println("Array needs more elements to be sorted");
		//}
	}

}
