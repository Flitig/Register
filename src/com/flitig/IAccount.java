package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public interface IAccount {
    int getBalance();

    void SetAccountTypeStrategy(IAccountTypeStrategy accountTypeStrategy);

    void TransactTo(int amount);

    void TransactFrom(int amount);
}
