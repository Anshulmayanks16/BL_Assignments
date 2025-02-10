// Interface for reservable library items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrowerName;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrowerName = "";
    }

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        isAvailable = available;
    }

    protected String getBorrowerName() {
        return borrowerName;
    }

    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // Abstract method to get loan duration
    public abstract int getLoanDuration();

    // Method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed by " + borrowerName));
    }
}

// Book class implementing Reservable
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // Loan duration for books is 21 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setAvailable(false);
            setBorrowerName(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class implementing Reservable
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Loan duration for magazines is 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setAvailable(false);
            setBorrowerName(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class implementing Reservable
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // Loan duration for DVDs is 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setAvailable(false);
            setBorrowerName(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class to demonstrate the library management system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        items[1] = new Magazine("M001", "National Geographic", "Various Authors");
        items[2] = new DVD("D001", "Inception", "Christopher Nolan");

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("John Doe");
                System.out.println("Availability after reservation: " + (((Reservable) item).checkAvailability() ? "Available" : "Not Available"));
            }

            System.out.println("-----------------------------");
        }
    }
}