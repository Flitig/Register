package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public class BalanceAccountStrategy implements IAccountTypeStrategy {

    // Specification: Utgifts- och inkomstkonton däremot minskar när de är to:- konton.

    @Override
    public int TransactFrom(int balance, int amount) {
        return balance + amount;
    }

    @Override
    public int TransactTo(int balance, int amount) {
        return balance - amount;
    }
}
