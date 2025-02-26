package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class CreateStudentJson {
    public static void main(String[] args) throws Exception {
        // Create Student object
        Student student = new Student("John Doe", 21, Arrays.asList("Math", "Science", "History"));
        
        // Convert Student object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);
        
        System.out.println("Student JSON: " + json);
    }
    
    public static class Student {
        private String name;
        private int age;
        private List<String> subjects;

        // Constructor, Getters, Setters, etc.
        public Student(String name, int age, List<String> subjects) {
            this.name = name;
            this.age = age;
            this.subjects = subjects;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<String> subjects) {
            this.subjects = subjects;
        }
    }
}
