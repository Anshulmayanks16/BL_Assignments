//Q10:Write a program that takes the distance in kilometers as input from the user and converts it into miles using the formula:


import java.util.Scanner;

public class program10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in kilometers: ");
        double kilometers = sc.nextDouble();
        double miles = kilometers * 0.621371;
        System.out.println("The distance in miles is: " + miles);
        
    }
}
