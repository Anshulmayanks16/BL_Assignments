import java.util.Scanner;

public class program8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your city of departure: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the city via which you are traveling: ");
        String viaCity = input.nextLine();

        System.out.print("Enter your final destination city: ");
        String toCity = input.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = input.nextDouble();

        System.out.print("Enter the total time taken for the trip (in hours): ");
        double timeTaken = input.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        System.out.println("The travel details are as follows:");
        System.out.println("Traveler's Name: " + name);
        System.out.println("From: " + fromCity);
        System.out.println("Via: " + viaCity);
        System.out.println("To: " + toCity);
        System.out.println("Total Distance Traveled: " + totalDistance + " miles");
        System.out.println("Time Taken: " + timeTaken + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles per hour");
    }
}