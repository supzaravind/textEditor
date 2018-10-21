package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class oddevencount {
public static void findcount(int[] numarr,int length)
{
	int oddcount=0;
	int evencount=0;
    int arr[];
    arr=numarr;
    int n=length;
    
    for(int i=0;i<n;i++)
    {
    	if(arr[i]%2==0)
    	{
    		evencount=evencount+1;
    	}else {
    	oddcount=oddcount+1;
    }
    }
    System.out.println("odd numbers count:" +oddcount);
    System.out.println("even numbers count:" +evencount);
    
}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
	
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the length of the array:");
int length=Integer.parseInt(br.readLine());
int numarr[] = new int[length];
System.out.println("Enter the array elements");

for(int i=0;i<length;i++) {
	System.out.print("Array["+i+"]");
	numarr[i]=Integer.parseInt(br.readLine());
}
System.out.print(java.util.Arrays.toString(numarr));
  findcount(numarr,length);
  
	}




	

}
