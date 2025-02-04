class Book {
    // Static variable shared across all books
    private static String libraryName = "City Central Library";
    
    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final variable, cannot be changed once assigned
    
    // Constructor using 'this' to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn; // Final variable initialized
    }
    
    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    
    // Method to display book details (using instanceof)
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("\n=== Book Details ===");
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid Book Object");
        }
    }
}

// Main class to test the implementation
public class LibraryApp {
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "978-0062315007");
        Book book2 = new Book("1984", "George Orwell", "978-0451524935");
        
        // Display library name
        Book.displayLibraryName();
        
        // Display book details
        book1.displayBookDetails();
        book2.displayBookDetails();
        
        // Checking instanceof usage
        System.out.println("\nIs book1 an instance of Book? " + (book1 instanceof Book));
    }
}