import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    // Add a product to the store
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add an item to the cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }

        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        updateSortedByPrice(product);
    }

    // Update TreeMap to sort items by price
    private void updateSortedByPrice(String product) {
        double price = productPrices.get(product);
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    // Display cart in order of items added
    public void displayCartOrder() {
        System.out.println("Cart (Order of Adding):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() + ", Price: " + productPrices.get(entry.getKey()));
        }
    }

    // Display cart items sorted by price
    public void displayCartByPrice() {
        System.out.println("Cart Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - Price: " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products
        cart.addProduct("Laptop", 1000.0);
        cart.addProduct("Mouse", 25.0);
        cart.addProduct("Keyboard", 50.0);
        cart.addProduct("Monitor", 200.0);

        // Add items to cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Keyboard", 1);
        cart.addToCart("Monitor", 1);

        // Display results
        cart.displayCartOrder();
        cart.displayCartByPrice();
    }
}
