package com.bankpackage;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000); // Initial balance of 1000

        // Create and start multiple customer threads
        Thread customer1 = new Thread(new Customer(sharedAccount, 300), "Customer 1");
        Thread customer2 = new Thread(new Customer(sharedAccount, 500), "Customer 2");
        Thread customer3 = new Thread(new Customer(sharedAccount, 400), "Customer 3");

        customer1.start();
        customer2.start();
        customer3.start();

        // Wait for all threads to finish
        try {
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final account balance: "  + sharedAccount.getBalance());
    }
}
