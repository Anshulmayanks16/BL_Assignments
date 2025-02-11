class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position < 1) {
            System.out.println("Position should be 1 or greater.");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        temp.next = temp.next.next;
    }

    // Search by Roll Number
    public Student searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display all students
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update Grade by Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtEnd(1, "Alice", 20, 'A');
        list.addAtBeginning(2, "Bob", 21, 'B');
        list.addAtPosition(2, 3, "Charlie", 22, 'C');

        System.out.println("All Students:");
        list.displayAll();

        System.out.println("\nSearching for Roll Number 3:");
        Student student = list.searchByRollNumber(3);
        if (student != null) {
            System.out.println("Found: Roll Number: " + student.rollNumber + ", Name: " + student.name);
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\nUpdating grade for Roll Number 2:");
        list.updateGrade(2, 'A');

        System.out.println("\nDeleting Roll Number 1:");
        list.deleteByRollNumber(1);

        System.out.println("\nAll Students after deletion:");
        list.displayAll();
    }
}
