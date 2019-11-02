package com.uday.com.uday.airtel;

public class Bank implements Runnable {

    @Override
    public void run() {
        Transaction t = new Transaction(new Account(0));
        t.deposit(5);
        t.withdraw(3);
    }

    public static void main(String [] args){

    }
}
