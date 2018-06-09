package node;

import object.Book;

public class BookNode {
	public Book book;

    public BookNode nextNode;

    public BookNode(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book){
        this.book = book;
    }
    public void setnextNode(BookNode nextNode) {
    	this.nextNode = nextNode;
    }
    public BookNode getnextNode() {
    	return 	this.nextNode;
    }
}
