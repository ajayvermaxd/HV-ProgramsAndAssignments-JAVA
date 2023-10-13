package Java.javaassignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Visitor {
    private String name;
    private int age;
    private String phoneNumber;
    private String appointmentDate;
    private String appointmentTimeSlot;

    public Visitor(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTimeSlot() {
        return appointmentTimeSlot;
    }

    public void setAppointmentTimeSlot(String appointmentTimeSlot) {
        this.appointmentTimeSlot = appointmentTimeSlot;
    }

    public void displayDetails() {
        System.out.println("Visitor Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time Slot: " + appointmentTimeSlot);
    }

    public String getName() {
        return null;
    }
}

class Clinic {
    private ArrayList<Visitor> visitors;
    private HashMap<String, ArrayList<String>> appointmentSchedule;

    public Clinic() {
        visitors = new ArrayList<>();
        appointmentSchedule = new HashMap<>();
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public void bookAppointment(Visitor visitor, String date, String timeSlot) {
        visitor.setAppointmentDate(date);
        visitor.setAppointmentTimeSlot(timeSlot);
        appointmentSchedule.computeIfAbsent(date, k -> new ArrayList<>()).add(visitor.getName());
    }
}

public class clinic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clinic clinic = new Clinic();

        System.out.println("Welcome to the Small Clinic Appointment Management System");

        while (true) {
            System.out.println("1. View Visitors List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Book an Appointment");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement viewing visitors list
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Visitor's Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Visitor's Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Visitor's Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    Visitor visitor = new Visitor(name, age, phoneNumber);
                    clinic.addVisitor(visitor);
                    System.out.println("Visitor added successfully.");
                    break;
                case 3:
                    // Implement booking an appointment
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
