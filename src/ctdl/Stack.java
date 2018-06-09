package ctdl;

import node.ReaderNode;
import object.Reader;

public class Stack {
	 public static ReaderNode StackTop = null;
	public void Push(Reader rd) {
		ReaderNode temp = new ReaderNode(rd);
		if(StackTop == null) {
			StackTop = temp;
		}else {
			temp.nextNode = StackTop;
			StackTop = temp;			
		}
	}
	
	public ReaderNode peak() {
		ReaderNode result = null;
		if(StackTop !=null) {
			result = StackTop;
		}
		return result;
		
	}

}