package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        // Create a list of Car objects
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "Model S", 2023));
        cars.add(new Car("BMW", "M3", 2022));

        // Convert list to JSON array
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(cars);

        System.out.println("JSON Array: " + jsonArray);
    }

    public static class Car {
        private String make;
        private String model;
        private int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }
}
