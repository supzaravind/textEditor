package dataStructures;

import java.io.IOException;



public class viewLinkedList {
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

	public static void main(String[] args)throws IOException {
		
		// TODO Auto-generated method stub
       viewLinkedList list1= new viewLinkedList();
        list1.head= new Node(10);    // initializing the head node data to 10
        // Since the first node is considered as head node, we move on to create second node
        Node secondNode = new Node(20); // initializing the second node data to 20
        Node thirdNode= new Node(30);     // initializing the third node data to 30
         list1.head.next = secondNode; // head node is linked to second node
         secondNode.next=thirdNode ;   // second node is linked to third node
         list1.display(list1.head);
        
	}


}
