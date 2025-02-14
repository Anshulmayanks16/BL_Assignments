public class MergeSort {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            
            merge(prices, left, mid, right);
        }
    }
    
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    public static void printArray(int[] array) {
        for (int price : array) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] bookPrices = {450, 120, 320, 560, 230, 410, 90};
        
        System.out.print("Original Book Prices: ");
        printArray(bookPrices);
        
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        
        System.out.print("Sorted Book Prices: ");
        printArray(bookPrices);
    }
}