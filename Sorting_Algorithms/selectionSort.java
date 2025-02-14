public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    
    public static void printArray(int[] array) {
        for (int score : array) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] examScores = {85, 72, 96, 50, 89, 77, 60};
        
        System.out.print("Original Exam Scores: ");
        printArray(examScores);
        
        selectionSort(examScores);
        
        System.out.print("Sorted Exam Scores: ");
        printArray(examScores);
    }
}