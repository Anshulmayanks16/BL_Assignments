// Interface for applying discounts
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();

    // Method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// VegItem class implementing Discountable
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
        System.out.println("Discount applied: " + discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Veg Item: " + discount;
    }
}

// NonVegItem class implementing Discountable
class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity, double additionalCharge) {
        super(itemName, price, quantity);
        this.additionalCharge = additionalCharge;
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + additionalCharge - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
        System.out.println("Discount applied: " + discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + discount;
    }
}

// Main class to demonstrate the food delivery system
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = new FoodItem[3];

        order[0] = new VegItem("Paneer Butter Masala", 250, 2);
        order[1] = new NonVegItem("Chicken Biryani", 300, 1, 50);
        order[2] = new VegItem("Veg Burger", 150, 3);

        processOrder(order);
    }

    public static void processOrder(FoodItem[] order) {
        for (FoodItem item : order) {
            item.getItemDetails();

            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10); // Applying 10% discount
                System.out.println(((Discountable) item).getDiscountDetails());
            }

            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println("-----------------------------");
        }
    }
}