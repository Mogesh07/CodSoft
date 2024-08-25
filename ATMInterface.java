import java.util.Scanner;

public class ATMInterface{
    private static int balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }
}
