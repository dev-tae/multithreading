package com.bankpackage;

public class Customer implements Runnable {
    private BankAccount account;
    private double amountToWithdraw;

    public Customer(BankAccount account, double amountToWithdraw) {
        this.account = account;
        this.amountToWithdraw = amountToWithdraw;
    }

    @Override
    public void run() {
        account.withdraw(amountToWithdraw);
    }
}
