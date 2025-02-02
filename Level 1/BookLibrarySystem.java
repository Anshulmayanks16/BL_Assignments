public class BookLibrarySystem {

    // Book Class
    public static class Book {
        public String ISBN;         // Public member
        protected String title;     // Protected member
        private String author;      // Private member
        
        // Constructor
        public Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }
        
        // Public method to set the author's name
        public void setAuthor(String author) {
            this.author = author;
        }
        
        // Public method to get the author's name
        public String getAuthor() {
            return this.author;
        }
        
        // Method to display book details
        public void displayBookDetails() {
            System.out.println("ISBN: " + ISBN);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    // EBook Class (Subclass of Book)
    public static class EBook extends Book {
        private double fileSizeMB;  // Additional member for file size
        
        // Constructor
        public EBook(String ISBN, String title, String author, double fileSizeMB) {
            super(ISBN, title, author);
            this.fileSizeMB = fileSizeMB;
        }
        
        // Method to display EBook details
        @Override
        public void displayBookDetails() {
            super.displayBookDetails();  // Call the parent method
            System.out.println("File Size: " + fileSizeMB + " MB");
        }
        
        // Method to access protected 'title' and public 'ISBN' from superclass
        public void printBookInfo() {
            System.out.println("ISBN from EBook: " + ISBN);
            System.out.println("Title from EBook: " + title);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create an instance of Book
        Book book1 = new Book("123-456-789", "Java Programming", "John Smith");
        book1.displayBookDetails();
        
        // Modify author name using public method
        book1.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book1.getAuthor());
        
        // Create an instance of EBook
        EBook eBook1 = new EBook("987-654-321", "Learning Java", "Alice Green", 2.5);
        eBook1.displayBookDetails();
        
        // Access protected 'title' and public 'ISBN' from subclass
        eBook1.printBookInfo();
    }
}
