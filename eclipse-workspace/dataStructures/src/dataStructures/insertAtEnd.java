package dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dataStructures.insertNode.Node;

public class insertAtEnd {

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
		 if(current==null)
		 {
			System.out.println("This list is empty");
		 }
		 while(current!=null) {
			 System.out.println(current.data);
			 current=current.next;
		 }
		 System.out.println(current);
	 }
	 public void insertend(int newdata )
	 {
		 Node current = head;    //node for traversing 
		 Node newnode= new Node(newdata);    // initializing the new node
		 if(current.next==null)              // check for the single element list
		 {         
		    newnode.next=null;
		    current.next=newnode;            
		 }
		 while(null!=current.next)            // traverses until the end of the list
		 {
			current=current.next;            // move to the next node
		 } 
		   current.next=newnode;             // add the new node to the end 
		   display(head);                     // display the list
		
	 }


	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
      insertAtEnd list1= new insertAtEnd();
       list1.head= new Node(10);    // initializing the head node data to 10
       // Since the first node is considered as head node, we move on to create second node
       Node secondNode = new Node(20); // initializing the second node data to 20
       Node thirdNode= new Node(30);     // initializing the third node data to 30
        list1.head.next = secondNode; // head node is linked to second node
        secondNode.next=thirdNode ;   // second node is linked to third node
        System.out.println("Enter the value to be inserted");
        int newdata= Integer.parseInt(br.readLine());
       list1.insertend(newdata);
        //list1.display(list1.head);
}
}
