package com.sandino;

import java.util.Scanner;

public class App {
    private static final String SEPARATOR = "-----------------------------";

    public static void main(String[] args) {
        int option = 0;
        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();

        while (option != 9) {
            System.out.println("1 - Create regular account");
            System.out.println("2 - Create bonus account");
            System.out.println("3 - Create savings account");
            System.out.println("4 - Check Balance");
            System.out.println("5 - Deposit");
            System.out.println("6 - Withdraw");
            System.out.println("7 - Transfer");
            System.out.println("8 - Earn interest");            
            System.out.println("9 - Exit");
            System.out.print("Choose an option: ");

            option = input.nextInt();

            System.out.println(SEPARATOR);

            if (option == 1) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.createRegularAccount(number);

                System.out.println(SEPARATOR);

            } else if (option == 2) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.createBonusAccount(number);

                System.out.println(SEPARATOR);

            } else if (option == 3) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                System.out.print("Please type the initial balance: ");

                double initialBalance = input.nextDouble();

                bank.createSavingsAccount(number, initialBalance);

                System.out.println(SEPARATOR);

            } else if (option == 4) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                bank.checkBalance(number);

                System.out.println(SEPARATOR);

            } else if (option == 5) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the amount: ");

                double amount = input.nextDouble();

                bank.deposit(number, amount);

                System.out.println(SEPARATOR);

            } else if (option == 6) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the amount: ");

                double amount = input.nextDouble();

                bank.withdraw(number, amount);

                System.out.println(SEPARATOR);

            } else if (option == 7) {
                System.out.print("Please type the sender account number: ");
                int sender = input.nextInt();

                System.out.print("Please type the receiver account number: ");
                int receiver = input.nextInt();

                System.out.print("Please type the amount: ");
                double amount = input.nextDouble();

                bank.transfer(sender, receiver, amount);

                System.out.println(SEPARATOR);

            } else if (option == 8) {
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
