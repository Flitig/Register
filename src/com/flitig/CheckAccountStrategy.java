package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public class CheckAccountStrategy implements IAccountTypeStrategy {

    @Override
    public int TransactFrom(int balance, int amount) {
        return balance - amount;
    }

    @Override
    public int TransactTo(int balance, int amount) {
        return balance + amount;
    }
}
