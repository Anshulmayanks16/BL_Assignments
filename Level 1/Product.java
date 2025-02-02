class Product {
    private char[] productName;
    private double price;
    private static int totalProducts = 0;

    // Constructor
    public Product(char[] productName, double price) {
        this.productName = copyCharArray(productName);
        this.price = price;
        totalProducts++;
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

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.print("Product Name: ");
        printCharArray(productName);
        System.out.println(" | Price: " + price);
    }

    // Static method to display total products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Print character array manually
    private void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        char[] name1 = {'L', 'a', 'p', 't', 'o', 'p'};
        char[] name2 = {'S', 'm', 'a', 'r', 't', 'p', 'h', 'o', 'n', 'e'};

        Product product1 = new Product(name1, 1200.50);
        Product product2 = new Product(name2, 800.75);

        product1.displayProductDetails();
        product2.displayProductDetails();
        Product.displayTotalProducts();
    }
}