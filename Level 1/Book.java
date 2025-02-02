class Book {
    private char[] title;
    private char[] author;
    private double price;

    // Default Constructor
    public Book() {
        this.title = new char[0];
        this.author = new char[0];
        this.price = 0.0;
    }

    // Parameterized Constructor
    public Book(char[] title, char[] author, double price) {
        this.title = copyCharArray(title);
        this.author = copyCharArray(author);
        this.price = price;
    }

    // Custom method to copy character arrays
    private char[] copyCharArray(char[] source) {
        if (source == null) return new char[0];
        char[] copy = new char[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    // Getters
    public char[] getTitle() {
        return copyCharArray(title);
    }

    public char[] getAuthor() {
        return copyCharArray(author);
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setTitle(char[] title) {
        this.title = copyCharArray(title);
    }

    public void setAuthor(char[] author) {
        this.author = copyCharArray(author);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display Method
    public void display() {
        System.out.print("Title: ");
        printCharArray(title);
        System.out.print(" | Author: ");
        printCharArray(author);
        System.out.println(" | Price: " + price);
    }

    // Method to print character array
    private void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        defaultBook.display();

        char[] title = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        char[] author = {'J', 'o', 'h', 'n', ' ', 'D', 'o', 'e'};
        Book paramBook = new Book(title, author, 499.99);
        paramBook.display();
    }
}