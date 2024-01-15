import java.util.ArrayList;

class User {
    int userId;
    String userName;
    ArrayList<Book> borrowedBooks;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

class Library {
    ArrayList<Book> books;
    ArrayList<User> users;
    int nextUserId;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.nextUserId = 1; // Initial user ID
    }

    public void addUser(String userName) {
        User newUser = new User(nextUserId++, userName);
        users.add(newUser);
        System.out.println("User added successfully: " + userName);
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added successfully: " + title);
    }

    public void displayBooks() {
        System.out.println("Book List:");
        for (Book book : books) {
            System.out.println(book.title + " by " + book.author + " - Available: " + book.available);
        }
    }

    public void borrowBook(String userName, String title) {
        User user = getUserByName(userName);
        if (user != null) {
            for (Book book : books) {
                if (book.title.equalsIgnoreCase(title) && book.available) {
                    book.available = false;
                    user.borrowBook(book);
                    System.out.println(user.userName + " has successfully borrowed: " + title);
                    return;
                }
            }
            System.out.println("Book not available for borrowing: " + title);
        } else {
            System.out.println("User not found: " + userName);
        }
    }

    public void returnBook(String userName, String title) {
        User user = getUserByName(userName);
        if (user != null) {
            for (Book book : user.borrowedBooks) {
                if (book.title.equalsIgnoreCase(title)) {
                    book.available = true;
                    user.returnBook(book);
                    System.out.println(user.userName + " has successfully returned: " + title);
                    return;
                }
            }
            System.out.println("Book not found in the borrowed list: " + title);
        } else {
            System.out.println("User not found: " + userName);
        }
    }

    private User getUserByName(String userName) {
        for (User user : users) {
            if (user.userName.equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }
}
