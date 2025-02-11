class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head = null;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add item at a specific position (1-based index)
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 1) {
            System.out.println("Position should be 1 or greater.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search by Item ID
    public void searchByItemId(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search by Item Name
    public void searchByItemName(String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item with name \"" + itemName + "\" not found.");
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Display all items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    // Sort inventory by Item Name
    public void sortByItemName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    // Sort inventory by Price
    public void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    // Merge Sort by Name
    private Item mergeSortByName(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSortByName(head, ascending);
        Item right = mergeSortByName(nextOfMiddle, ascending);

        return sortedMergeByName(left, right, ascending);
    }

    private Item sortedMergeByName(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        if ((ascending && left.itemName.compareTo(right.itemName) <= 0) || (!ascending && left.itemName.compareTo(right.itemName) > 0)) {
            result = left;
            result.next = sortedMergeByName(left.next, right, ascending);
        } else {
            result = right;
            result.next = sortedMergeByName(left, right.next, ascending);
        }
        return result;
    }

    // Merge Sort by Price
    private Item mergeSortByPrice(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSortByPrice(head, ascending);
        Item right = mergeSortByPrice(nextOfMiddle, ascending);

        return sortedMergeByPrice(left, right, ascending);
    }

    private Item sortedMergeByPrice(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        if ((ascending && left.price <= right.price) || (!ascending && left.price > right.price)) {
            result = left;
            result.next = sortedMergeByPrice(left.next, right, ascending);
        } else {
            result = right;
            result.next = sortedMergeByPrice(left, right.next, ascending);
        }
        return result;
    }

    // Get middle of the linked list
    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryApp {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtEnd("Laptop", 101, 10, 750.50);
        inventory.addAtBeginning("Mouse", 102, 50, 15.75);
        inventory.addAtPosition(2, "Keyboard", 103, 30, 25.00);

        inventory.displayAllItems();

        System.out.println("\nUpdating quantity for Item ID 101:");
        inventory.updateQuantity(101, 8);

        System.out.println("\nSearching for Item by ID 103:");
        inventory.searchByItemId(103);

        System.out.println("\nCalculating total inventory value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting inventory by Item Name in ascending order:");
        inventory.sortByItemName(true);
        inventory.displayAllItems();

        System.out.println("\nSorting inventory by Price in descending order:");
        inventory.sortByPrice(false);
        inventory.displayAllItems();
    }
}