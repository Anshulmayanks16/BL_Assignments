import java.util.Arrays;

public class OTPGenerator {

    // Method to generate a 6-digit OTP number using Math.random()
    public static int generateOTP() {
        // Generate a random 6-digit number
        return (int) (Math.random() * 900000) + 100000; // Ensures the number is always 6 digits
    }

    // Method to ensure that the OTP numbers generated are unique
    public static boolean areUniqueOTPs(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // OTPs are not unique
                }
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {
        // Array to store 10 OTP numbers
        int[] otps = new int[10];
        
        // Generate 10 OTPs and store them in the array
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
            System.out.println("Generated OTP #" + (i + 1) + ": " + otps[i]);
        }

        // Check if all generated OTPs are unique
        if (areUniqueOTPs(otps)) {
            System.out.println("\nAll OTPs are unique.");
        } else {
            System.out.println("\nSome OTPs are duplicate.");
        }
    }
}
