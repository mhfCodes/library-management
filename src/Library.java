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
			System.out.println("(Add Book Data = 1)\n(Get Book Data = 2)\n(Exit = 3)");
			choice = scanner.nextInt();
			switch (choice) {
				case (1):
					// add book
					System.out.println("Book Added");
					break;
				case (2):
					// get book
					System.out.println("Information retreived");
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
