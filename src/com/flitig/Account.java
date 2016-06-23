package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public class Account implements IAccount {
    private final String name;
    private IAccountTypeStrategy accountTypeStrategy;
    private int balance;

    Account(String name) {
        this.name = name;
        balance = 0;
    }

    @Override
    public void SetAccountTypeStrategy(IAccountTypeStrategy accountTypeStrategy) {
        this.accountTypeStrategy = accountTypeStrategy;
    }

    @Override
    public void TransactTo(int amount) {
        balance = accountTypeStrategy.TransactTo(balance, amount);
    }

    @Override
    public void TransactFrom(int amount) {
        balance = accountTypeStrategy.TransactFrom(balance, amount);
    }


    @Override
    public String toString() {
        return String.format("%s:%d", name, balance);
    }
}
