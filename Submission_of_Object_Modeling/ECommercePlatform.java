import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {

    // Product Class (Represents individual products)
    static class Product {
        private String name;
        private double price;

        // Constructor
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void displayProductInfo() {
            System.out.println(name + " - $" + price);
        }
    }

    // Order Class (Aggregates multiple Products)
    static class Order {
        private static int orderCounter = 0; // To generate order IDs
        private int orderId;
        private Customer customer;
        private List<Product> products;

        // Constructor
        public Order(Customer customer) {
            this.orderId = ++orderCounter; // Increment and assign order ID
            this.customer = customer;
            this.products = new ArrayList<>();
        }

        // Add product to the order
        public void addProduct(Product product) {
            if (!products.contains(product)) {
                products.add(product);
            }
        }

        // Display the order details
        public void displayOrderInfo() {
            System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
            System.out.println("Products in this order:");
            for (Product product : products) {
                product.displayProductInfo();
            }
            System.out.println("Total Price: $" + calculateTotalPrice());
        }

        // Calculate the total price of the order
        public double calculateTotalPrice() {
            double total = 0;
            for (Product product : products) {
                total += product.getPrice();
            }
            return total;
        }

        public int getOrderId() {
            return orderId;
        }
    }

    // Customer Class (Places orders and has a list of orders)
    static class Customer {
        private String name;
        private String email;
        private List<Order> orders;

        // Constructor
        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
            this.orders = new ArrayList<>();
        }

        // Method to place an order
        public Order placeOrder() {
            Order order = new Order(this);
            orders.add(order);
            return order;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        // Display customer info and orders
        public void displayCustomerInfo() {
            System.out.println("Customer: " + name + " | Email: " + email);
            if (orders.isEmpty()) {
                System.out.println("No orders placed yet.");
            } else {
                for (Order order : orders) {
                    order.displayOrderInfo();
                    System.out.println();
                }
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        // Create customer
        Customer customer1 = new Customer("Alice", "alice@example.com");

        // Customer places an order
        Order order1 = customer1.placeOrder();
        order1.addProduct(product1);
        order1.addProduct(product2);

        // Customer places another order
        Order order2 = customer1.placeOrder();
        order2.addProduct(product3);

        // Display customer and their orders
        customer1.displayCustomerInfo();
    }
}
