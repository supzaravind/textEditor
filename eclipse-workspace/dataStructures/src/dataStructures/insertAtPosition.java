package dataStructures;

import java.io.*;



public class insertAtPosition {

	 Node head;
	 static class Node   // Declared static so that main can access it directly
	 {
		 int data;       // Each node has a data and value associated with it 
		 Node next;
		 public Node(int dataValue)  // constructor initialize the data and next value
		 {
			 data=dataValue;
			 next=null;
		 }
		 
	 }
	 public void display(Node head)
	 {
		 Node current= head;
		 int count=1;
		 if(current==null)
		 {
			System.out.println("This list is empty");
		 }
		 while(current!=null) {
			 System.out.println("Index["+count+"]"+current.data);
			 current=current.next;
			 count++;
		 }
		 System.out.println(current);
	 }
	 
	 public int listlength(Node head)
	 {
		  System.out.println("inside the length");
		 Node current=head;  // node to traverse the list
		 int length=1;       // buffer to track the number of elements through traversal
		 while (current!=null)    // check for the end of the list
		 {
			 length++;                
			 current=current.next;   // move to the next node in the list
		
		 }
		
		 return length;
	 } 
	 
	public void insertlocation(Node head, int newdata, int pos)
	{
		Node previous=head;  //	Node previous is created to traverse through the list
		Node nodeinsert=new Node(newdata); //New node initialized by calling the constructor
		int count=1;                       // count is used to track the position while traversing
		
		while(count<pos-1)            // condition to reach the previous node before insert location 
		{
			
			previous=previous.next;      // traverse through the list
			count++;
		}

		nodeinsert.next=previous.next;    // insert the node.Reassign the next value
		previous.next=nodeinsert;         // assign previous to the new node
	    display(head);
	    System.out.println("LENGTH OF THE LIST : " +listlength(head));
	       
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
      insertAtPosition list1= new insertAtPosition(); 
     
       list1.head= new Node(10);    // initializing the head node data to 10
       // Since the first node is considered as head node, we move on to create second node
       Node secondNode = new Node(20); // initializing the second node data to 20
       Node thirdNode= new Node(30);     // initializing the third node data to 30
        list1.head.next = secondNode; // head node is linked to second node
        secondNode.next=thirdNode ; // second node is linked to third node
        list1.display(list1.head);
        int length=list1.listlength(list1.head);
        System.out.println("LENGTH OF THE LIST : " +length);
        System.out.println("Please enter the value to be inserted: ");
        int newvalue= Integer.parseInt(br.readLine());
        
       System.out.println("Please enter the position to be inserted: ");
       int position= Integer.parseInt(br.readLine());
       
       list1.insertlocation(list1.head,newvalue, position);    //passing the head,new value to be inserted and the position to be isnerted
      
	}



}
