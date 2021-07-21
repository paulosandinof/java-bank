package com.sandino;

import java.util.Scanner;

public class App {
    private static final String SEPARATOR = "-----------------------------";
    public static void main(String[] args) {
        int option = 0;
        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();

        while (option != 6) {
            System.out.println("1 - Create account");
            System.out.println("2 - Check Balance");
            System.out.println("3 - Deposit");
            System.out.println("4 - Withdraw");
            System.out.println("6 - Exit");
            System.out.print("Choose an option: ");

            option = input.nextInt();

            System.out.println(SEPARATOR);

            if (option == 1) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.createAccount(number);

                System.out.println(SEPARATOR);

            } else if (option == 2) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                bank.checkBalance(number);

                System.out.println(SEPARATOR);

            } else if (option == 3) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the amount: ");
                
                double amount = input.nextDouble();

                bank.deposit(number, amount);

                System.out.println(SEPARATOR);
            } else if (option == 4) {
                System.out.print("Please type an account number: ");

                int number = input.nextInt();

                System.out.print("Please type the amount: ");
                
                double amount = input.nextDouble();

                bank.withdraw(number, amount);
            }
        }
        input.close();
    }
}
