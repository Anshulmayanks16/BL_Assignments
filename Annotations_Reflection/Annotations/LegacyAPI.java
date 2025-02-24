// Legacy class with an old method
class LegacyAPI {
    
    // Marking this method as deprecated
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature. Do not use it!");
    }

    // New recommended method
    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        api.oldFeature(); // This will show a warning in modern IDEs
        api.newFeature(); // Recommended method
    }
}
