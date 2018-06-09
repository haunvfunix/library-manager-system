package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ctdl.LinkedList;
import ctdl.Queue;
import ctdl.Stack;
import node.LendingNode;
import node.ReaderNode;
import object.Book;
import object.Lending;
import object.Reader;

public class MainClass {
	static Stack stack = new Stack();
	static Queue queue = new Queue();
	static LinkedList ll = new LinkedList();
	
	public static void main(String[] args) {
		  menu();
	
		int choice =0;
		while(choice != 13) {
			Scanner sc = new Scanner(System.in);
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("Nhap sai nhap lai");

			}finally {
				if(choice == 1) {
					AddBookTail();
					menu();
				}else if(choice ==2) {
					DisPlayDataBook();
					menu();
				}else if(choice == 3) {
					String code = sc.nextLine();
					
					ll.search(code);
					menu();
					
				}else if(choice == 4) {
					AddBookHear();
					menu();
				}else if(choice == 5) {
					System.out.println("nhap vi tri can them");
					int position = sc.nextInt();
					Book book = new Book();
					inputBook(book);
					ll.add(position, book);
					menu();
					
				}else if(choice == 6) {
					System.out.println("Nhap vi tri can xoa");
					int position = sc.nextInt();
					ll.deleteItem(position);
					menu();
				}else if(choice == 7) {
					Reader r = new Reader();
					inputReader(r);
					stack.Push(r);
					menu();
				}else if(choice == 8) {
					disPlayReader();
					menu();
				}else if(choice == 9) {
					System.out.println("Nhap Bcode cần tìm");
					String code = sc.nextLine();
					searchNodeStack(code);
					menu();
				}else if(choice == 10) {
					System.out.println("Nhap Bcode cần xóa");
					String code = sc.nextLine();
					deleteNodeStack(code);
					menu();
				}else if(choice == 11) {
					Lending len = new Lending();
					inputLending(len);
					queue.push(len);
				}else if(choice == 12) {
					disPlayLen();
					menu();
				}
			}
		}		
	}
	public static ReaderNode searchNodeStack(String rcode) {
		ReaderNode TopNode =stack.peak();
		ReaderNode NodeResult =null;
		while(TopNode != null) {
			if(TopNode.getReader().getBcode().equals(rcode)) {
				NodeResult = TopNode;
			}
			TopNode = TopNode.nextNode;
		}
		if(NodeResult == null) {
			System.out.println("Không có kết quả phù hợp");
		}else {
			System.out.printf("%-10s|%-10s|%-10d\n",NodeResult.reader.getBcode(),NodeResult.reader.getName(),NodeResult.reader.getByear());
		}
		return NodeResult;
	}
	public static void deleteNodeStack(String rcode) {
		Stack stack2 = new Stack();
		ReaderNode TopNode =stack.peak();
		boolean bool = true;
		while(TopNode != null && bool == true) {
			if(TopNode.getReader().getBcode().equals(rcode)) {
				Stack.StackTop = TopNode.nextNode;
				bool = false;	
			}else if(bool ==true) {
				stack2.Push(TopNode.reader);
				TopNode = TopNode.nextNode;
			}
		}
		ReaderNode TopNode2 =stack2.peak();
		while(TopNode2 != null) {
			stack.Push(TopNode2.reader);
			TopNode2 = TopNode2.nextNode;
		}
	}
	public static void AddBookTail() {
		Book book = new Book();
		inputBook(book);
		ll.addTail(book);
	}
	public static void AddBookHear() {
		Book book = new Book();
		inputBook(book);
		ll.addHear(book);
	}
	
	public static void menu(){
		System.out.println("______________________________MENU___________________________________");
		System.out.println("|_____________________________BOOK__________________________________|");
		System.out.println("|1 Input & add to the end___________________________________________|");
		System.out.println("|2 Display Book_____________________________________________________|");
		System.out.println("|3 Search by boce___________________________________________________|");
		System.out.println("|4 Input & add to beginning_________________________________________|");
		System.out.println("|5 Add after position  k____________________________________________|");
		System.out.println("|6 Delete position k________________________________________________|");
		System.out.println("|_____________________________READER________________________________|");
		System.out.println("|7 Add reader_______________________________________________________|");
		System.out.println("|8 Display data_____________________________________________________|");
		System.out.println("|9 Search by rcode__________________________________________________|");
		System.out.println("|10 Delete by rcode_________________________________________________|");
		System.out.println("|____________________________LENDING________________________________|");
		System.out.println("|11 Input data______________________________________________________|");
		System.out.println("|12 Display data____________________________________________________|");
		System.out.println("|____________________________13 EXIT________________________________|");
	}
	
	public static Book inputBook(Book book) {
		Scanner sc = new Scanner(System.in);
		boolean boolLended = false;
		boolean boolQuantity = false;
		boolean boolPrice = false;
		boolean boolBcode = false;
		boolean boolBcode2 = false;
		
		System.out.println("Nhập Bcode");
		while (boolBcode == false) {
			int count = 0;
			String Bcode = sc.nextLine();
			for (int i = 0; i < ll.Length(); i++) {
				if (ll.getItem(i).book.getBcode().equals(Bcode) == true) {
					System.out.println("Bcode đã trùng");
					count--;
				}
				count++;
			}
			if (count == (ll.Length())) {
				boolBcode = true;
				book.setBcode(Bcode);
			}
		}
		System.out.println("Nhập Title");
		String Title = sc.nextLine();
		book.setTitle(Title);

		System.out.println("Nhập Lended");
		while (boolLended == false) {
			try {
				int Lended = Integer.parseInt(sc.nextLine());
				book.setLended(Lended);
				boolLended = true;
			} catch (NumberFormatException e) {
				System.out.println("Gia tri sai,nhập lại");
			}
		}
		System.out.println("Nhập Quantity");
		while (boolQuantity == false) {
			try {
				int Quantity = Integer.parseInt(sc.nextLine());
				book.setQuantity(Quantity);
				if (Quantity >= book.getLended()) {
					boolQuantity = true;
				} else {
					System.out.println("giá trị Quantity >= Lended");
					System.out.println("Nhập lại");
				}
			} catch (NumberFormatException e) {
				System.out.println("Gia tri sai");
			}
		}
		System.out.println("Nhập Price");
		while (boolPrice == false) {
			try {
				double Price = Double.parseDouble(sc.nextLine());
				book.setPrice(Price);
				boolPrice = true;
			} catch (NumberFormatException e) {
				System.out.println("Gia tri sai");
			}
		}
		return book;
	}
	public static void DisPlayDataBook() {
		System.out.printf("%-10s|%-30s|%-10s|%-10s|%-10s|%-10s \n","CODE","TITLE","QUANTITY","LENDED","PRICE","VALUE");
		for (int i = 0; i < ll.Length(); i++) {
			String code= ll.getItem(i).book.getBcode();
			String title = ll.getItem(i).book.getTitle();
			int quantity = ll.getItem(i).book.getQuantity();
			int len = ll.getItem(i).book.getLended();
			double price = ll.getItem(i).book.getPrice();
			double value = price * quantity ;
			System.out.printf("%-10s|%-30s|%-10d|%-10d|%-10.2f|%.2f \n",code,title,quantity,len,price,value);
		}	
	}
	public static Reader inputReader(Reader reader) {
		Scanner sc = new Scanner(System.in);
		boolean boolBcode = false;
		boolean boolYear = false;
		
		System.out.println("Nhập Bcode");
		while(boolBcode == false) {
			int count = 0;
			ReaderNode RD  = stack.peak();
			String Bcode = sc.nextLine();
			if(RD == null) {
				boolBcode = true;
			    reader.setBcode(Bcode);
			}
			while(RD != null) {
				if(RD.reader.getBcode().equals(Bcode)) {
					count--;
					System.out.println("Bcode đã trùng");
					boolBcode = false;
				}
				count++;
				RD = RD.nextNode;
				 if(count == (LengthStack())) {
					 boolBcode = true;
					 reader.setBcode(Bcode);
				 }
			}
		}
		System.out.println("Nhap ten Reader");
		String name = sc.nextLine();
		reader.setName(name);
		System.out.println("Nhap năm  sinh");
		
		while (boolYear == false) {
			try {
				
				int Year = Integer.parseInt(sc.nextLine());
				if(Year > 1990 && Year < 2010) {
					reader.setByear(Year);
					boolYear = true;
				}else {
					System.out.println("Khoang gia tri khong đúng");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Gia tri sai,nhập lại");
			}
		}
		return reader;	
	}
	public static int LengthStack() {
		int count = 0;
		ReaderNode RD  = stack.peak();
		while(RD != null) {
			count++;
			RD = RD.nextNode;
		}
		return count;
	}
	
	public static void disPlayReader() {
		ReaderNode rd = stack.peak();
		while(rd != null) {
			System.out.printf("%-10s|%-10s|%-10d\n",rd.reader.getBcode(),rd.reader.getName(),rd.reader.getByear());
			rd = rd.nextNode;
		}
	}
	
	public static Lending inputLending(Lending len) {
		System.out.println("Nhap Bcode");
		Scanner sc = new Scanner(System.in);
		
		boolean bollBcode = false;
		while(bollBcode == false) {
			String Bcode = sc.nextLine();
			for (int i = 0; i < ll.Length(); i++) {
				if(ll.getItem(i).book.getBcode().equals(Bcode)) {
					bollBcode = true;
				   }
		         }
			if(bollBcode == true) {
				len.setBcode(Bcode);
			}else {
				System.out.println("Nhap lai gia tri Bcode");
			}
		}
		
	    System.out.println("Nhap Rcode");
	    boolean bollRcode = false;
	    while( bollRcode == false) {
	    	String Rcode = sc.nextLine();
	    	ReaderNode r = stack.peak();
	    	while(r != null) {
	    		if(r.reader.getBcode().equals(Rcode)) {
	    			bollRcode = true;
	    		}
	    		r = r.nextNode;
	    	}
	    	if(bollRcode == true) {
	    		len.setRcode(Rcode);
	    	}else {
	    		System.out.println("Nhap lai gia tri Rcode");
	    	}
	    }
	    System.out.println("Nhập state");
	    
	    boolean bollState = false;
	    
		while(bollState == false) {
			int state = sc.nextInt();
			if(state >= 0 && 2 <= state) {
				len.setState(state);
				bollState = true;
			}else {
				System.out.println("nhâp lại giá trị");
			}
		}
		return len;
	}
	public static void disPlayLen() {
		LendingNode len = queue.peak();
		while(len != null) {
			System.out.printf("%-5s|%-10s|%-5d \n",len.getLending().getBcode(),len.getLending().getRcode(),len.getLending().getState());
			len = len.nextNode;
		}
		
	}

}
