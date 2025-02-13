class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0; // Total petrol - total distance
        int currSurplus = 0;  // Current fuel balance
        int startIndex = 0;   // Potential start point

        for (int i = 0; i < n; i++) {
            int balance = petrol[i] - distance[i];
            totalSurplus += balance;
            currSurplus += balance;

            // If at any point fuel balance is negative, reset startIndex
            if (currSurplus < 0) {
                startIndex = i + 1;
                currSurplus = 0;
            }
        }

        // If totalSurplus is negative, no valid tour exists
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        System.out.println(start == -1 ? "No circular tour possible" : "Start at pump " + start);
    }
}