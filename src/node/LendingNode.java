package node;

import object.Lending;

public class LendingNode {
	public Lending len;
    public LendingNode nextNode;


    public LendingNode(Lending len) {
    	  this.len = len;
	}

	public Lending getLending() {
        return len;
    }

    public void setLending(Lending len){
        this.len = len;
    }
    public void setnextNode(LendingNode nextNode) {
    	this.nextNode = nextNode;
    }
    public LendingNode getnextNode() {
    	return 	this.nextNode;
    }

}