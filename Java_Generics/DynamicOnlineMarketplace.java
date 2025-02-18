
import java.util.*;

// 1. Category interfaces
interface BookCategory {}
interface ClothingCategory {}
interface GadgetCategory {}

// 2. Generic Product Class
abstract class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public abstract void displayDetails();
}

// 3. Product Types (Book, Clothing, Gadget)
class Book extends Product<BookCategory> {
    private String author;

    public Book(String name, double price, BookCategory category, String author) {
        super(name, price, category);
        this.author = author;
    }

    @Override
    public void displayDetails() {
        System.out.println(" Book: " + getName() + ", Author: " + author + ", Price: $" + getPrice());
    }
}

class Clothing extends Product<ClothingCategory> {
    private String size;

    public Clothing(String name, double price, ClothingCategory category, String size) {
        super(name, price, category);
        this.size = size;
    }

    @Override
    public void displayDetails() {
        System.out.println(" Clothing: " + getName() + ", Size: " + size + ", Price: $" + getPrice());
    }
}

class Gadget extends Product<GadgetCategory> {
    private String brand;

    public Gadget(String name, double price, GadgetCategory category, String brand) {
        super(name, price, category);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("🔌 Gadget: " + getName() + ", Brand: " + brand + ", Price: $" + getPrice());
    }
}

// 4. Product Catalog (Stores multiple product types)
class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    // Add a product of any category
    public <T> void addProduct(Product<T> product) {
        products.add(product);
    }

    // Display all products in the catalog
    public void displayAllProducts() {
        for (Product<?> product : products) {
            product.displayDetails();
        }
    }

    // Generic method to apply a discount on any product type
    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println(" Applied " + percentage + "% discount on: " + product.getName());
    }
}

// 5. Main Class (Testing the system)
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        // Create product categories
        BookCategory fiction = new BookCategory() {};
        ClothingCategory mensWear = new ClothingCategory() {};
        GadgetCategory electronics = new GadgetCategory() {};

        // Create products
        Book book1 = new Book("The Great Gatsby", 20.00, fiction, "F. Scott Fitzgerald");
        Clothing tshirt = new Clothing("Graphic T-Shirt", 30.00, mensWear, "M");
        Gadget phone = new Gadget("Smartphone", 800.00, electronics, "Samsung");

        // Create product catalog
        ProductCatalog catalog = new ProductCatalog();

        // Add products to the catalog
        catalog.addProduct(book1);
        catalog.addProduct(tshirt);
        catalog.addProduct(phone);

        // Display initial product catalog
        System.out.println(" Initial Product Catalog:");
        catalog.displayAllProducts();

        // Apply discounts dynamically
        catalog.applyDiscount(book1, 10);  // 10% off on the book
        catalog.applyDiscount(tshirt, 20); // 20% off on the t-shirt
        catalog.applyDiscount(phone, 5);   // 5% off on the gadget

        // Display updated product catalog
        System.out.println("\n Updated Product Catalog:");
        catalog.displayAllProducts();
    }
}