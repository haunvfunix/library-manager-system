package node;

import object.Reader;

public class ReaderNode {
	public Reader reader;

    public ReaderNode nextNode;


    public ReaderNode(Reader reader) {
    	this.reader = reader;
	}

	public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader){
        this.reader = reader;
    }
    public void setnextNode(ReaderNode nextNode) {
    	this.nextNode = nextNode;
    }
    public ReaderNode getnextNode() {
    	return 	this.nextNode;
    }
}
