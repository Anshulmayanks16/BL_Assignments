// Base class Order
class Order {
    private String orderId;
    private String orderDate;

    // Constructor
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Getter methods
    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    // Method to get order status
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

// Subclass ShippedOrder
class ShippedOrder extends Order {
    private String trackingNumber;

    // Constructor
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);  // Calling superclass constructor
        this.trackingNumber = trackingNumber;
    }

    // Getter for tracking number
    public String getTrackingNumber() {
        return trackingNumber;
    }

    // Overriding getOrderStatus to include shipping status
    @Override
    public String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }
}

// Subclass DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    // Constructor
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);  // Calling superclass constructor
        this.deliveryDate = deliveryDate;
    }

    // Getter for delivery date
    public String getDeliveryDate() {
        return deliveryDate;
    }

    // Overriding getOrderStatus to include delivery status
    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

// Main class to test
public class OrderManagementSystem {
    public static void main(String[] args) {
        // Creating an Order
        Order order = new Order("ORD123", "2024-02-01");

        // Creating a ShippedOrder
        ShippedOrder shippedOrder = new ShippedOrder("ORD124", "2024-02-02", "TRK56789");

        // Creating a DeliveredOrder
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", "2024-02-03", "TRK98765", "2024-02-05");

        // Displaying statuses
        System.out.println("Order Status: " + order.getOrderStatus());
        System.out.println("Shipped Order Status: " + shippedOrder.getOrderStatus());
        System.out.println("Delivered Order Status: " + deliveredOrder.getOrderStatus());
    }
}