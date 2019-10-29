package com.uday.com.uday.airtel;

public class Transaction {

    private int balance = 0;

    public int getBalance(){
        return this.balance;
    }

    public String depositMoney(int m){
        balance += m;
        return String.format("Depositing %s money",m);
    }

    public String withdrawtMoney(int m){
        if(balance >= m){
            balance -= m;
            return String.format("Withdrawing %s money",m);
        }
        return String.format("Withdrawing %s money (Insufficient Balance)",m);
    }



}
