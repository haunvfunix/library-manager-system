package ctdl;

import node.BookNode;
import object.Book;

public class LinkedList {
	private BookNode HeadNode = null;
	 private int mSize = 0;
	public void addHear(Book book) {
		BookNode temp = new BookNode(book);
		if(HeadNode == null) {
			HeadNode = temp;
		}else {
			 temp.nextNode = HeadNode;
			 HeadNode = temp;
		}
		
	}
	
	 public void addTail(Book book) {
	        BookNode TailNode = new BookNode(book);
	        if (HeadNode == null) {
	        	HeadNode = TailNode;
	        } else {
	        	BookNode tailListNode = HeadNode;
	            while (tailListNode.nextNode != null) {
	                tailListNode = tailListNode.nextNode;
	            }
	            tailListNode.nextNode = TailNode;
	        }
	      
	    }
	 
	 public void add(int position,Book book) {
		 BookNode node = new BookNode(book);
		 if(this.Length() == 0) {
			 HeadNode = node;
		 }else {
			 if(position == this.Length()-1) {
				 addTail(book);
			 }else {
				 BookNode valueNode = HeadNode;
				    int currentPos = 0;
			        while (currentPos < position) {
			            valueNode = valueNode.nextNode;
			            currentPos++;
			        }
			        BookNode currAfter = valueNode.nextNode;
			        valueNode.nextNode = node;
			        node.nextNode = currAfter;
			 }
			   
		 }
		 
	 }
	
	
	 
	 public BookNode getItem(int position) {
	        if (position < 0 || position >= this.Length()) {
	            throw new IndexOutOfBoundsException("required index " + position + " but actually has " + (this.Length() - 1));
	        }
	        BookNode valueNode = HeadNode;
	        int currentPos = 0;
	        while (currentPos < position) {
	            valueNode = valueNode.nextNode;
	            currentPos++;
	        }
			return valueNode;
	        
	    }
	 public void deleteItem(int position) {
	        if (position < 0 || position >= this.Length()) {
	            throw new IndexOutOfBoundsException("required index " + position + " but actually has " + (this.Length() - 1));
	        }
	        BookNode valueNode = HeadNode;
	      
	        if(position == 0) {
	        	HeadNode = valueNode.nextNode;
	        }else {
	        	  int currentPos =1;
	        	  while (currentPos < position) {
	 	            valueNode = valueNode.nextNode;
	 	            currentPos++;
	 	        }
	        	  valueNode.nextNode = valueNode.nextNode.nextNode;
	        }
	    }
	 
	 public int Length() {
		 int size = 0;
		 BookNode current = HeadNode;
		 while(current != null) {
			 current = current.nextNode;
			 size++;
		 }
		return size;
		 
	 }
	 
	 public BookNode search(String Xcode) {	
		 BookNode current = HeadNode;
		 BookNode result = null;
		 for (int i = 0; i < this.Length(); i++) {
			if(Xcode.equals(current.book.getBcode())) {
				result = current;
			}
			 current = current.nextNode;
		}
		 if(result == null) {
			 System.out.println("Khong co gia trị phù hợp");
		 }else {
			 
			 System.out.printf("%-10s|%-30s|%-10s|%-10s|%-10s|%-10s \n","CODE","TITLE","QUANTITY","LENDED","PRICE","VALUE");
		     System.out.printf("%-10s|%-30s|%-10d|%-10d|%-10.2f|%.2f \n",result.book.getBcode(),
																  result.book.getTitle(),
																  result.book.getQuantity(),
																  result.book.getLended(),
													              result.book.getPrice(),
													              ( result.book.getQuantity() * result.book.getPrice()));
		 }
		return result;
		
	 }

}
