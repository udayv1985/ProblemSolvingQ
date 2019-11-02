package com.uday.com.uday.airtel;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private Account account;

    public Transaction(Account account){
        this.account = account;
    }

    private List<String> transactions = new ArrayList<>();

    public synchronized void deposit(int m){
        transactions.add(this.account.depositMoney(m));
    }

    public synchronized void withdraw(int m){
        transactions.add(this.account.withdrawtMoney(m));
    }

    public List<String> getTransactions(){
        return this.transactions;
    }

}
