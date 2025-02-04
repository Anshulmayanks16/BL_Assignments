// Define the Product class
class Product {
    // Static variable shared across all products
    private static double discount = 10.0; // Default discount in percentage
    
    // Instance variables
    private String productName;
    private final int productID; // Final variable, cannot be changed once assigned
    private double price;
    private int quantity;
    
    // Constructor using 'this' to resolve ambiguity
    public Product(String productName, int productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID; // Final variable initialized
        this.price = price;
        this.quantity = quantity;
    }
    
    // Static method to update the discount for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    // Method to calculate final price after discount
    public double calculateFinalPrice() {
        return price * quantity * (1 - discount / 100);
    }
    
    // Method to display product details (using instanceof)
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("\n=== Product Details ===");
            System.out.println("Product Name: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Price: $" + calculateFinalPrice());
        } else {
            System.out.println("Invalid Product Object");
        }
    }
}

// Main class to test the implementation
public class ShoppingCartApp {
    public static void main(String[] args) {
        // Creating product objects
        Product product1 = new Product("Laptop", 101, 1200.00, 1);
        Product product2 = new Product("Smartphone", 102, 800.00, 2);
        
        // Display initial product details
        product1.displayProductDetails();
        product2.displayProductDetails();
        
        // Updating discount
        Product.updateDiscount(15.0); // Change discount to 15%
        System.out.println("\nUpdated discount applied to all products!");

        // Display product details after discount update
        product1.displayProductDetails();
        product2.displayProductDetails();
        
        // Checking instanceof usage
        System.out.println("\nIs product1 an instance of Product? " + (product1 instanceof Product));
    }
}