package ctdl;

import node.LendingNode;
import object.Lending;

public class Queue {
	 //  LendingNode TailNode = null;
	   LendingNode TopNode = null;
	   public void push(Lending len) {
		   LendingNode TailNode = new LendingNode(len);
		   if(TopNode == null) {
			   TopNode = TailNode;
		   }else {
			   LendingNode listNode = TopNode;
			  while(listNode.nextNode != null) {
				  listNode = listNode.nextNode;
			  }
			  listNode.nextNode = TailNode;
			 
		   }
	   }
	   public LendingNode peak() {
		   LendingNode result = null;
			if(TopNode !=null) {
				result = TopNode;
			}
			return result;
			
		}
	}