package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {
    public static void main(String[] args) throws Exception {
        // Create Car object
        Car car = new Car("Tesla", "Model S", 2023);
        
        // Convert Car object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(car);
        
        System.out.println("Car JSON: " + json);
    }
    
    public static class Car {
        private String make;
        private String model;
        private int year;

        // Constructor, Getters, Setters
        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}
