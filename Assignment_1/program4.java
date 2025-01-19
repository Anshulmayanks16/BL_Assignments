//Q4:Write a program to calculate the area of a circle. Take the radius as input and use the formula:


import java.util.Scanner;

public class program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle is: " + area);
       
    }
}
