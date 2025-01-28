import java.util.Random;

public class MatrixOperations {

    // Method to create a random matrix with the specified number of rows and columns
    public static int[][] createRandomMatrix(int rows, int columns) {
        Random rand = new Random();
        int[][] matrix = new int[rows][columns];
        
        // Fill the matrix with random numbers between 1 and 10
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextInt(10) + 1; // Random number between 1 and 10
            }
        }
        return matrix;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix2[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to transpose a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Method to find the determinant of a 2x2 matrix
    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // Method to find the inverse of a 2x2 matrix
    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) {
            System.out.println("Matrix is singular, inverse does not exist.");
            return null;
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double) det;
        inverse[0][1] = -matrix[0][1] / (double) det;
        inverse[1][0] = -matrix[1][0] / (double) det;
        inverse[1][1] = matrix[0][0] / (double) det;
        return inverse;
    }

    public static void main(String[] args) {
        // Create random 2x2 matrices
        int[][] matrix1 = createRandomMatrix(2, 2);
        int[][] matrix2 = createRandomMatrix(2, 2);

        // Display the matrices
        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("\nMatrix 2:");
        printMatrix(matrix2);

        // Perform addition of the matrices
        int[][] additionResult = addMatrices(matrix1, matrix2);
        System.out.println("\nMatrix Addition Result:");
        printMatrix(additionResult);

        // Perform subtraction of the matrices
        int[][] subtractionResult = subtractMatrices(matrix1, matrix2);
        System.out.println("\nMatrix Subtraction Result:");
        printMatrix(subtractionResult);

        // Perform multiplication of the matrices
        int[][] multiplicationResult = multiplyMatrices(matrix1, matrix2);
        System.out.println("\nMatrix Multiplication Result:");
        printMatrix(multiplicationResult);

        // Perform transposition of the matrices
        int[][] transposeResult = transposeMatrix(matrix1);
        System.out.println("\nMatrix 1 Transposed:");
        printMatrix(transposeResult);

        // Calculate the determinant and inverse of a 2x2 matrix
        int det = determinant2x2(matrix1);
        System.out.println("\nDeterminant of Matrix 1: " + det);

        double[][] inverse = inverse2x2(matrix1);
        if (inverse != null) {
            System.out.println("\nInverse of Matrix 1:");
            for (int i = 0; i < inverse.length; i++) {
                for (int j = 0; j < inverse[i].length; j++) {
                    System.out.print(inverse[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}