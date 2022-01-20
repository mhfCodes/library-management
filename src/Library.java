import java.util.Scanner;

public class Library {
	
	String title;
	String author;
	String genre;
	int price;
	
	Library() {
		System.out.println("*** Hello ***");
		System.out.println(" -- Welcome to this library -- ");
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean loggedIn = true;
		while (loggedIn) {
			System.out.println(" ------- Please Select Your Option: -------");
			System.out.println("(Add Book Data = 1)\n(Get All Books Data = 2)\n(Exit = 3)");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case (1):
					System.out.print("Please Enter The Title of Your Book: ");
					this.title = scanner.nextLine();
					System.out.print("Please Enter The Author of Your Book: ");
					this.author = scanner.nextLine();
					System.out.print("Please Enter The Genre of Your Book: ");
					this.genre = scanner.nextLine();
					System.out.print("Please Enter The Price of Your Book: ");
					this.price = scanner.nextInt();
					DB.addBook(this.title, this.author, this.genre, this.price);
					break;
				case (2):
					DB.getBooks();
					break;
				case (3):
					System.out.println("Good Bye");
					loggedIn = false;
					break;
				default:
					System.out.println("You've Entered a Wrong Option.");
			
			}	
		}
	}
}
