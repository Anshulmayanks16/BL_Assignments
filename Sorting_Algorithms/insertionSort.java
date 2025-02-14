public class InsertionSortManual {
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            
            // Move elements that are greater than key one position ahead
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] employeeIds = {105, 102, 110, 101, 108, 103};
        
        System.out.print("Original Employee IDs: ");
        printArray(employeeIds);
        
        insertionSort(employeeIds);
        
        System.out.print("Sorted Employee IDs: ");
        printArray(employeeIds);
    }
}