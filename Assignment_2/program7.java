public class program7 {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double conversionFactor = 1.609;

       double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);


        double radiusMiles = radiusKm / conversionFactor;
        double volumeMiles3 = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 +
                           " and cubic miles is " + volumeMiles3);
    }
}