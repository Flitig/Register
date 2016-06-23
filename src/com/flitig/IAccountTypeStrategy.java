package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public interface IAccountTypeStrategy {
    int TransactFrom(int balance, int amount);

    int TransactTo(int balance, int amount);
}
