class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head = null;
    private Book tail = null;

    // Add book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add book at a specific position (1-based index)
    public void addAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position < 1) {
            System.out.println("Position should be 1 or greater.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newBook.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newBook;
        } else {
            tail = newBook;
        }
        temp.next = newBook;
        newBook.prev = temp;
    }

    // Remove book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search by Book Title
    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Book with title \"" + title + "\" not found.");
        }
    }

    // Search by Author
    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Books by author \"" + author + "\" not found.");
        }
    }

    // Update Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability status updated for Book ID " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book temp = head;
        System.out.println("Library Books (Forward):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book temp = tail;
        System.out.println("Library Books (Reverse):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count total number of books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books in the library: " + count);
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addAtEnd("1984", "George Orwell", "Dystopian", 101, true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addAtPosition(2, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 103, false);

        library.displayForward();

        System.out.println("\nUpdating availability for Book ID 101:");
        library.updateAvailability(101, false);

        System.out.println("\nSearching for Book by Title '1984':");
        library.searchByTitle("1984");

        System.out.println("\nCounting total books:");
        library.countBooks();

        System.out.println("\nDisplaying books in reverse order:");
        library.displayReverse();

        System.out.println("\nRemoving Book ID 102:");
        library.removeByBookId(102);
        library.displayForward();
    }
}
