public class SpringSeason {
    public static void main(String[] args) {
        // Ensure two command line arguments are passed
        if (args.length != 2) {
            System.out.println("Please provide two arguments: month and day.");
            return;
        }

        // Parse the month and day from the command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if the date falls within the Spring season (March 20 to June 20)
        if ((month == 3 && day >= 20) || 
            (month == 4) || 
            (month == 5) || 
            (month == 6 && day <= 20)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}