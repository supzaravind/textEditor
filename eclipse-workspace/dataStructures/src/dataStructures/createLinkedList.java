package dataStructures;
import java.io.*;

public class createLinkedList {
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

	public static void main(String[] args)throws IOException {
		
		// TODO Auto-generated method stub
       createLinkedList list1= new createLinkedList();
        list1.head= new Node(10);    // initialzing the head node data to 10
        // Since the first node is considered as head node, we move on to create second node
        Node secondNode = new Node(20); // initialzing the second node data to 20
        Node thirdNode= new Node(30);     // initialzing the third node data to 30
         list1.head.next = secondNode; // head node is linked to second node
         secondNode.next=thirdNode ;   // second node is linked to third node
         
        
	}

}
