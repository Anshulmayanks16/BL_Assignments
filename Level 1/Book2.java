class Book {
    private char[] title;
    private char[] author;
    private double price;
    private boolean isAvailable;

    // Default Constructor
    public Book() {
        this.title = new char[0];
        this.author = new char[0];
        this.price = 0.0;
        this.isAvailable = true;
    }

    // Parameterized Constructor
    public Book(char[] title, char[] author, double price) {
        this.title = copyCharArray(title);
        this.author = copyCharArray(author);
        this.price = price;
        this.isAvailable = true;
    }

    // Copy character array manually
    private char[] copyCharArray(char[] source) {
        if (source == null) return new char[0];
        char[] copy = new char[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // Method to display book details
    public void displayBook() {
        System.out.print("Title: ");
        printCharArray(title);
        System.out.print(" | Author: ");
        printCharArray(author);
        System.out.println(" | Price: " + price + " | Available: " + isAvailable);
    }

    // Print character array manually
    private void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        char[] title = {'L', 'i', 'b', 'r', 'a', 'r', 'y', ' ', 'B', 'o', 'o', 'k'};
        char[] author = {'A', 'u', 't', 'h', 'o', 'r', ' ', 'N', 'a', 'm', 'e'};
        Book book = new Book(title, author, 299.99);

        book.displayBook();
        if (book.borrowBook()) {
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
        book.displayBook();
    }
}