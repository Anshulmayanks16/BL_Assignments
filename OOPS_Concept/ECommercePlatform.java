// Interface for Taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method for discount calculation
    public abstract double calculateDiscount();

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics class implementing Taxable
class Electronics extends Product implements Taxable {
    private double discountRate;
    private double taxRate;

    public Electronics(int productId, String name, double price, double discountRate, double taxRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * (discountRate / 100);
    }

    @Override
    public double calculateTax() {
        return getPrice() * (taxRate / 100);
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate + "%";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: " + calculateDiscount());
        System.out.println(getTaxDetails());
    }
}

// Clothing class implementing Taxable
class Clothing extends Product implements Taxable {
    private double discountAmount;
    private double taxRate;

    public Clothing(int productId, String name, double price, double discountAmount, double taxRate) {
        super(productId, name, price);
        this.discountAmount = discountAmount;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return discountAmount;
    }

    @Override
    public double calculateTax() {
        return getPrice() * (taxRate / 100);
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate + "%";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: " + calculateDiscount());
        System.out.println(getTaxDetails());
    }
}

// Groceries class without Tax (Non-Taxable)
class Groceries extends Product {
    private double discountRate;

    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * (discountRate / 100);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: Non-Taxable");
    }
}

// Main class to demonstrate functionality
public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Electronics(201, "Laptop", 75000, 10, 18);
        products[1] = new Clothing(202, "Jacket", 3000, 500, 12);
        products[2] = new Groceries(203, "Apples", 200, 5);

        for (int i = 0; i < products.length; i++) {
            products[i].displayDetails();
            System.out.println("Final Price: " + calculateFinalPrice(products[i]));
            System.out.println("-----------------------------");
        }
    }

    // Method to calculate final price (price + tax - discount)
    public static double calculateFinalPrice(Product product) {
        double price = product.getPrice();
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
        }

        return price + tax - discount;
    }
}