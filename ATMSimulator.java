import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000, withdraw, deposit;
        String pin = "1234";
        int attempts = 0;

        System.out.print("Enter PIN: ");
        String userPin = sc.nextLine();

        while (!userPin.equals(pin) && attempts < 2) {
            System.out.println("Incorrect PIN. Try again.");
            attempts++;
            System.out.print("Enter PIN: ");
            userPin = sc.nextLine();
        }

        if (!userPin.equals(pin)) {
            System.out.println("Too many failed attempts. Exiting.");
            return;
        }

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    withdraw = sc.nextInt();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Withdrawal Successful!");
                    } else {
                        System.out.println("Insufficient Balance.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    deposit = sc.nextInt();
                    balance += deposit;
                    System.out.println("Deposit Successful!");
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);

        sc.close();
    }
}
