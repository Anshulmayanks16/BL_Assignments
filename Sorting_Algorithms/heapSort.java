public class HeapSort {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root with last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            
            // Heapify reduced heap
            heapify(salaries, i, 0);
        }
    }
    
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;
            
            heapify(salaries, n, largest);
        }
    }


   public static void printArray(int[] array) {
        for (int salary : array) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 60000, 80000, 40000, 90000, 100000};
        
        System.out.print("Original Salary Demands: ");
        printArray(salaries);
        
        heapSort(salaries);
        
        System.out.print("Sorted Salary Demands: ");
        printArray(salaries);
    }
}
