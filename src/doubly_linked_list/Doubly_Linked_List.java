package doubly_linked_list;

import java.util.Scanner;

public class Doubly_Linked_List {
	static Node head;
	static Node tail;
	static int length;
	
	private static void prepend(int element) {
		
		
		Node temp=new Node(element);
		if(head==null)
		{
			head=temp;
			tail=temp;
			
		}
		else
		{
		head.left=temp;
		temp.right=head;
		head=temp;
		}
		length++;
	}	
	
	private void addIndex(int element, int index) {
		// TODO Auto-generated method stub
		
		if(index==0 || head==null)
		{
			prepend(element);
		}
		else if(index<0 || index>length)
	    {
	    	System.out.println("Enter a valid index from 0 to "+ length);
	    	return;
	    }
		
		else if(index==length)
		{
			append(element);
		}
		
		else
		{
			Node node=new Node(element);
			Node temp=head;
			for(int i=0;i<index-1;i++)
			{
				temp=temp.right;
			}
			node.right=temp.right;
			temp.right.left=temp;
			node.left=temp;
			temp.right=node;
			
			length++;
		}
		
		
	}
	
	private static void append(int element) {
		// TODO Auto-generated method stub
		
		Node node=new Node(element);
		if(head==null)
		{
			head=node;
			tail=node;
			length++;
			return;
		}
		else
		{
			Node temp=head;
			while(temp.right!=null)
			{
				temp=temp.right;
			}
			temp.right=node;
			node.left=temp;
			
		}
		tail=node;
		length++;
		
	}

	
	
	private static Node Remove_First() {
		if(head==null)
		{
			return null;
		}
		
		head=head.right;
		head.left=null;
		
		length--;
		return head;
	}
	
	private Node RemoveIndex(int index) {
		// TODO Auto-generated method stub
		if(head==null)
		{
			System.out.println("No element present in the list");
		}
		if(index<0 || index>length)
	    {
	    	System.out.println("Enter a valid index from 0 to "+ (length-1));
	    	return null;
	    }
		else if(index==0)
		{
			return Remove_First();
		}
		else if(index==length)
		{
			return Remove_Last();
		}
		else
		{
			Node temp=head;
			for(int i=0;i<index-1;i++)
			{
				temp=temp.right;
			}
			Node right_temp=temp.right;
			Node left_temp=temp.left;
			right_temp.left=left_temp;
			left_temp.right=right_temp;
			length--;
			return temp;
			
		}
		
		
	}

	private static  Node Remove_Last() {
		if(length<=0)
		{
			return null;
		}
		 if(length==1)
		{
			length--;
		//	System.out.println(head.value);
			Node temp=head;
			head=null;
			tail=null;
			return temp;
			
		}
		else if(length==2)
		{
			length--;
		//	System.out.println(head.next.value);
			Node temp=head.right;
			head.right=null;
			tail=head;
			return temp;
		}
		else
		{
			length--;
			Node temp=head;
			while(temp.right!=null)
			{
				temp=temp.right;
			}
			temp.left.right=null;
			tail=temp.left;
			temp.left=null;
			
			return temp;
			
		}
	}
	
	
	private static Node getElement(int index) {
		if(index<0 || index>=length)
		{
			return null;
		}
		else if(index==0)
		{
			return head;
		}
		else if(index==length-1)
		{
			return tail;
		}
		else
		{
			Node temp=head;
			for(int i=0;i<index;i++)
			{
				temp=temp.right;
			}
			return temp;
		}
		
	}
	private boolean SetElement(int index,int element) {
		if(index<0 || index>=length)
		{
			return false;
		}
		else
		{
			Node temp=getElement(index);
			temp.value=element;
			return true;
			
		}
	}
	private void display() {
		
		if(length==0)
		{
			System.out.println("Empty List");
			return;
		}
		System.out.print (length+  "      The elements in the list are : ");
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.value+"  ");
			temp=temp.right;
		}
		System.out.println();

		
	}
	private static Node getTail() {
		
		return tail;
		
	}
	private static Node getHead() {
		return head;
	}
	private static void reverse() {
		
		Node current=head;
		while(current!=null)
		{
			Node temp=current.right;
			current.right=current.left;
			current.left=temp;
			current=temp;
			
		}
		current=head;
		head=tail;
		tail=current;	
	}
	public static void main(String[] args) {
		
		
		Doubly_Linked_List node = new Doubly_Linked_List();
		Scanner scanner=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Enter the input \n 1) Add an element at first \n 2) Add an element at particular index   \n 3)  Append an element at last   \n "
					+ "4) Remove an element at first \n 5) Remove an element at particular index in the list  \n 6) Remove an element at last  "
					+ " \n 7) Get the head of the list  \n 8) Get the tail of the list \n 9) Get the value present in the index \n"
					+ " 10) Update the value present in the index \n 11) Reverse the LinkedList");
			
		
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter the element to be prepended : ");
				int element=scanner.nextInt();
				node.prepend(element);
				System.out.println(element + " is successfully inserted");
				node.display();
				break;
				
				
			}
			case 2:
			{
				System.out.println("Enter the element to be inserted at the particular index : ");
				int element=scanner.nextInt();
				System.out.println("Enter the index ");
				int index=scanner.nextInt();
				node.addIndex(element,index);
				System.out.println(element + " is successfully inserted");
				node.display();
				break;
				
				
			
				
			}
			case 3:
			{
				

				System.out.println("Enter the element to be appended : ");
				int element=scanner.nextInt();
				node.append(element);
				System.out.println(element + " is successfully inserted");
				node.display();
				break;
				
				
				
			}
			case 4:
			{
				Node temp=node.Remove_First();
				if(temp==null)
				{
					System.out.println("List is empty");
				}
				else
				{
				System.out.println(temp.value);
				}
				node.display();
				
				
			}
			case 5:
			{
				System.out.println("Enter the element of the index to be removed ");
				int index=scanner.nextInt();
				Node element=node.RemoveIndex(index);
				if(element==null)
				{
					System.out.println("List is Empty");
				}
				else
				{
				System.out.println(element.value + " is successfully deleted");
				
				}
				node.display();
				break;
			}
			case 6:
			{
				Node element=node.Remove_Last();
				if(element!=null)
				{
				System.out.println(element.value+ " is successfully deleted");
				node.display();
				}
				else
				{
					System.out.println("Empty List");
				}
				
				break;
			}
			case 7:
			{
				Node element=node.getHead();
				if(element==null)
				{
					System.out.println("Empty List");
				}
				else
				{
					System.out.println(element.value);
				}
				break;
			}
			case 8:
			{
				Node element=node.getTail();
				if(element==null)
				{
					System.out.println("Empty List");
				}
				else
				{
					System.out.println(element.value);
				}
				break;
			}
			case 9:
			{
				System.out.println("Enter the index of the element to be fetched ");
				int index=scanner.nextInt();
				Node element=node.getElement(index);
				if(element==null)
				{
					System.out.println("Entered index is invalid");
				}
				else
				{
				System.out.println("The element present in the given index is "+element.value);
				}
				break;
			}
			case 10:
			{
				System.out.println("Enter the index of the element to be updated ");
				int index=scanner.nextInt();
				System.out.println("Enter the value to be updated ");
				int element=scanner.nextInt();
				if(!node.SetElement(index,element))
				{
					System.out.println("Entered index is invalid");
				}
				else
				{
				System.out.println("The element present in the given index is updated");
				}
				node.display();
				break;
				
			}
			case 11:
			{
				reverse();
				System.out.println("List after reversed ");
				node.display();
				break;
			}
			default:
			{
				System.out.println("Enter a valid input");
			}
			}
		
	}
	}
}

	
