package com.sandino;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();

        while (option != 6) {
            System.out.println("1 - Create account");
            System.out.println("2 - Check Balance");
            System.out.println("6 - Exit");
            System.out.print("Choose an option: ");

            option = input.nextInt();

            System.out.println("-----------------------------");

            if (option == 1) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.createAccount(number);

                System.out.println("-----------------------------");

            } else if (option == 2) {
                System.out.print("Please type a number: ");

                int number = input.nextInt();

                bank.checkBalance(number);

                System.out.println("-----------------------------");

            }
        }
        input.close();
    }
}
