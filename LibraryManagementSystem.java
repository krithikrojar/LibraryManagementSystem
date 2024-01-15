import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter user name: ");
                    String userName = scanner.nextLine();
                    library.addUser(userName);
                    break;

                case 2:
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.println("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.println("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(userName, borrowTitle);
                    break;

                case 5:
                    System.out.println("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.println("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(userName, returnTitle);
                    break;

                case 6:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
