package com.bankpackage;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            System.out.println(Thread.currentThread().getName() + " successfully withdrew " + amount + ". Remaining balance: " + this.balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient funds. Remaining balance: " + this.balance);
        }
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + this.balance);
    }

    public double getBalance() {
        return this.balance;
    }
}
