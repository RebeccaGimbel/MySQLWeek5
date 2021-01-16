package books;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import books.dao.BookDao;
import books.entity.Book;

public class BookApp {
	
	private Scanner scanner = new Scanner(System.in);
	private BookDao bookDao = new BookDao();
	int option;

	public static void main(String[] args) {
		new BookApp().run();
	}

	private void run() {
		do
		{
			listMenu();
			
			try {
			System.out.print("Enter a selection: ");
			option = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("\n\t*****\tSelection must be a number\t*****");
			}
			
			try {
			switch(option) {
				case 1:
					addBook();
					break;
					
				case 2:
					modifyBook();
					break;
					
				case 3:
					listBooks();
					break;
					
				case 4:
					deleteBook();
					break;
					
				case 5:
					System.out.println("\n\tHave a nice day");
					System.out.println("\n\tPress any key to exit");
					scanner.nextLine();
					break;
					
				default:
					System.out.println("\n\t*****\tInvalid selecion, try again!\t*****");				
			}
			}
			catch(SQLException e) {
				System.out.println("There was an error during the switch statement" + e.getMessage());
				break;
			}
			} while (option != 5);
	
			System.exit(0);
		}
	

	private void deleteBook() throws SQLException {
		System.out.print("\nEnter the ID # of the book you would like to delete: ");
		int bookId = Integer.parseInt(scanner.nextLine());
		
		bookDao.deleteBook(bookId);
	}

	private void listBooks() throws SQLException {
		List<Book> books = bookDao.listBooks();
				
		for (Book book : books) {
			System.out.println("\n\tID # " + book.getBookId() + "\tTitle: " + book.getTitle());
		}		
	}

	private void modifyBook() throws SQLException {
		listBooks();
		System.out.print("\nEnter the ID # of the book you would like to change: ");
		int bookId = Integer.parseInt(scanner.nextLine());
		
		System.out.print("\nEnter the new corrected title: ");
		String title = scanner.nextLine();
		
		bookDao.modifyBook(bookId, title);
	}

	private void addBook() throws SQLException {
		System.out.print("\nEnter the title of the book you would like to add: ");
		String title = scanner.nextLine();
		bookDao.addBook(title);
	}

	private void listMenu() {
		System.out.println("\nMenu\n------------------------");
		System.out.println("1- Add a book");
		System.out.println("2- Update name of a book");
		System.out.println("3- List all books");
		System.out.println("4- Delete a book");
		System.out.println("5- Exit program");
	}	
}
