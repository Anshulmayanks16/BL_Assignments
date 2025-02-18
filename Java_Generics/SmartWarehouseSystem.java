
import java.util.*;

// 1. Abstract class representing a warehouse item
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayDetails();
}

// 2. Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand + ", Price: $" + getPrice());
    }
}

// 3. Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + getName() + ", Expiry Date: " + expiryDate + ", Price: $" + getPrice());
    }
}

// 4. Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material + ", Price: $" + getPrice());
    }
}

// 5. Generic storage class for warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    // Add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Get all items from storage
    public List<T> getItems() {
        return items;
    }

    // Display all items in this storage
    public void displayStorage() {
        for (T item : items) {
            item.displayDetails();
        }
    }
}

// 6. Utility class for warehouse operations
class WarehouseManager {
    // Wildcard method to display any type of WarehouseItem
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

// 7. Main class to demonstrate the system
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Create storage for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to the storage
        electronicsStorage.addItem(new Electronics("Laptop", 1200.00, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.00, "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", 3.50, "2025-12-31"));
        groceriesStorage.addItem(new Groceries("Rice", 15.00, "2026-06-15"));

        furnitureStorage.addItem(new Furniture("Sofa", 750.00, "Leather"));
        furnitureStorage.addItem(new Furniture("Table", 150.00, "Wood"));

        // Display items within individual storages
        System.out.println(" Electronics Storage:");
        electronicsStorage.displayStorage();

        System.out.println("\n Groceries Storage:");
        groceriesStorage.displayStorage();

        System.out.println("\n Furniture Storage:");
        furnitureStorage.displayStorage();

        // Using the wildcard method to display all items
        System.out.println("\n Displaying all items via wildcard method:");
        WarehouseManager.displayItems(electronicsStorage.getItems());
        WarehouseManager.displayItems(groceriesStorage.getItems());
        WarehouseManager.displayItems(furnitureStorage.getItems());
    }
}