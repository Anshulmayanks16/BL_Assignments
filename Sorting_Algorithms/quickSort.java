public class QuickSort {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; 
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        
        return i + 1;
    }
    
    public static void printArray(int[] array) {
        for (int price : array) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] productPrices = {700, 150, 400, 1000, 350, 200, 900};
        
        System.out.print("Original Product Prices: ");
        printArray(productPrices);
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.print("Sorted Product Prices: ");
        printArray(productPrices);
    }
}