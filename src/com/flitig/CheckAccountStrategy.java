package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public class CheckAccountStrategy implements IAccountTypeStrategy {

    // Specification: Saldot för check-konton ökar när kontot är ett to:-konto

    @Override
    public int TransactFrom(int balance, int amount) {
        return balance - amount;
    }

    @Override
    public int TransactTo(int balance, int amount) {
        return balance + amount;
    }
}
