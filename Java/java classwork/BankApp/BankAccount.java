package BankApp;

import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;
    private String contactInfo;
    private String address;

    public BankAccount(String ownerName, String contactInfo, String address) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name can't be null or empty.");
        }
        if (contactInfo == null || contactInfo.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact info can't be null or empty.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address can't be null or empty.");
        }

        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.address = address;
        this.balance = 0.0;
        this.accountNumber = generateAccountNumber();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount);
        System.out.println("Remaining Balance: " + balance);
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Address: " + address);
        System.out.println("Balance: " + balance);
    }

    private String generateAccountNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(899999) + 100000;
        return String.valueOf(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();

        System.out.print("Enter contact info: ");
        String contact = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        BankAccount account = new BankAccount(owner, contact, address);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Display details");
            System.out.println("4: Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a correct option.");
            }
        }
    }
}