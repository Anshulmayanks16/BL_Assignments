public class LibrarySystem {

    // Book Class
    static class Book {
        private String title;
        private String author;

        // Constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Display book details
        public void displayBookInfo() {
            System.out.println("Title: " + title + ", Author: " + author);
        }
    }

    // Library Class
    static class Library {
        private String libraryName;
        private Book[] books;
        private int bookCount;

        // Constructor
        public Library(String libraryName, int maxBooks) {
            this.libraryName = libraryName;
            this.books = new Book[maxBooks];  // Fixed size array instead of ArrayList
            this.bookCount = 0;
        }

        // Add book to library
        public void addBook(Book book) {
            if (bookCount < books.length) {
                books[bookCount] = book;
                bookCount++;
            } else {
                System.out.println("Library is full! Cannot add more books.");
            }
        }

        // Display all books in the library
        public void displayLibraryBooks() {
            System.out.println("Library: " + libraryName);
            for (int i = 0; i < bookCount; i++) {
                books[i].displayBookInfo();
            }
            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create independent book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Create library objects with capacity for 5 books each
        Library library1 = new Library("City Library", 5);
        Library library2 = new Library("Community Library", 5);

        // Add books to libraries (Aggregation: Books can belong to multiple libraries)
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);  // Same book added to a different library
        library2.addBook(book3);

        // Display books in each library
        library1.displayLibraryBooks();
        library2.displayLibraryBooks();

        // Demonstrating that books exist independently of libraries
        System.out.println("Book details exist independently of libraries:");
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
    }
}