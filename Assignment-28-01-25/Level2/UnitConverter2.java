public class UnitConverter {

    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        // Example usage of the UnitConverter methods
        
        // Convert 10 yards to feet
        double yards = 10;
        System.out.println(yards + " yards is equal to " + convertYardsToFeet(yards) + " feet.");
        
        // Convert 30 feet to yards
        double feet = 30;
        System.out.println(feet + " feet is equal to " + convertFeetToYards(feet) + " yards.");
        
        // Convert 5 meters to inches
        double meters = 5;
        System.out.println(meters + " meters is equal to " + convertMetersToInches(meters) + " inches.");
        
        // Convert 50 inches to meters
        double inches = 50;
        System.out.println(inches + " inches is equal to " + convertInchesToMeters(inches) + " meters.");
        
        // Convert 60 inches to centimeters
        double inchesForCm = 60;
        System.out.println(inchesForCm + " inches is equal to " + convertInchesToCm(inchesForCm) + " centimeters.");
    }
}