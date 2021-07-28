package com.sandino;

import java.util.Scanner;

public class App {
    private static final String SEPARATOR = "-----------------------------";

    public static void main(String[] args) {
        int option = 0;
        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();

        while (option != 8) {
            System.out.println("1 - Create account");
            System.out.println("2 - Create savings account");
            System.out.println("3 - Check Balance");
            System.out.println("4 - Deposit");
            System.out.println("5 - Withdraw");
            System.out.println("6 - Transfer");
            System.out.println("7 - Earn interest");
            System.out.println("8 - Exit");
            System.out.print("Choose an option: ");

            option = input.nextInt();

            System.out.println(SEPARATOR);

            if (option == 1) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.createAccount(number);

                System.out.println(SEPARATOR);

            } else if (option == 2) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.createSavingsAccount(number);

                System.out.println(SEPARATOR);
            } else if (option == 3) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                bank.checkBalance(number);

                System.out.println(SEPARATOR);

            } else if (option == 4) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the amount: ");

                double amount = input.nextDouble();

                bank.deposit(number, amount);

                System.out.println(SEPARATOR);

            } else if (option == 5) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the amount: ");

                double amount = input.nextDouble();

                bank.withdraw(number, amount);

                System.out.println(SEPARATOR);

            } else if (option == 6) {
                System.out.print("Please type the sender account number: ");
                int sender = input.nextInt();

                System.out.print("Please type the receiver account number: ");
                int receiver = input.nextInt();

                System.out.print("Please type the amount: ");
                double amount = input.nextDouble();

                bank.transfer(sender, receiver, amount);

                System.out.println(SEPARATOR);

            } else if (option == 7) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the percentage: ");

                double percentage = input.nextDouble();

                bank.earnInterest(number, percentage);

                System.out.println(SEPARATOR);

            }
        }
        input.close();
    }
}
