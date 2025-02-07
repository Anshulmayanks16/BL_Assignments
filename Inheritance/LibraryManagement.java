// Author class
class Author {
    private String name;
    private String bio;

    // Constructor
    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    // Display Author info
    public void displayInfo() {
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Book class
class Book {
    private String title;
    private int publicationYear;
    private Author author;  // Composition: Book has an Author

    // Constructor
    public Book(String title, int publicationYear, Author author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    // Display Book and Author info
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        author.displayInfo(); // Delegating author info display
    }
}

// Main class to test
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an Author
        Author author = new Author("J.K. Rowling", "British author, best known for the Harry Potter series.");

        // Creating a Book with the Author
        Book book = new Book("Harry Potter and the Philosopher's Stone", 1997, author);

        // Displaying Book and Author information
        book.displayInfo();
    }
}