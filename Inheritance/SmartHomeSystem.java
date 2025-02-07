// Superclass Device
class Device {
    private String deviceId;
    private String status;

    // Constructor
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Getter methods
    public String getDeviceId() {
        return deviceId;
    }

    public String getStatus() {
        return status;
    }

    // Display device status
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass Thermostat
class Thermostat extends Device {
    private int temperatureSetting;

    // Constructor
    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);  // Calling superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Getter method for temperature
    public int getTemperatureSetting() {
        return temperatureSetting;
    }

    // Overriding displayStatus to include temperature
    @Override
    public void displayStatus() {
        super.displayStatus();  // Display general device status
        System.out.println("Temperature Setting: " + temperatureSetting + "\u00B0C");
    }
}

// Main class to test
public class SmartHomeSystem {
    public static void main(String[] args) {
        // Creating a general device
        Device genericDevice = new Device("Device001", "Online");
        
        // Creating a thermostat device
        Thermostat thermostat = new Thermostat("Thermo001", "Active", 22);

        // Displaying statuses
        System.out.println("Generic Device Status:");
        genericDevice.displayStatus();
        
        System.out.println("\nThermostat Status:");
        thermostat.displayStatus();
    }
}