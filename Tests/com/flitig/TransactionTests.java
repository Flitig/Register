package com.flitig;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Flitig on 2016-06-23.
 */

public class TransactionTests {
    @Test
    public void TestsTransactionFromCheckAccount() throws Exception {

        // Specification: Saldot för check-konton ökar när kontot är ett to:-konto

        IAccount account = new Account("Test");
        account.SetAccountTypeStrategy(new CheckAccountStrategy());

        account.TransactFrom(10);

        int actual = account.getBalance();
        int expected = -10;

        assertEquals(expected, actual);
    }

    @Test
    public void TestsTransactionToCheckAccount() throws Exception {

        // Specification: Saldot för check-konton ökar när kontot är ett to:-konto

        IAccount account = new Account("Test");
        account.SetAccountTypeStrategy(new CheckAccountStrategy());
        account.TransactTo(10);

        int actual = account.getBalance();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    public void TestsTransactionFromBalanceAccount() throws Exception {

        // Specification: Utgifts- och inkomstkonton däremot minskar när de är to:- konton.

        IAccount account = new Account("Test");
        account.SetAccountTypeStrategy(new BalanceAccountStrategy());

        account.TransactFrom(10);

        int actual = account.getBalance();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    public void TestsTransactionToBalanceAccount() throws Exception {

        // Specification: Utgifts- och inkomstkonton däremot minskar när de är to:- konton.

        IAccount account = new Account("Test");
        account.SetAccountTypeStrategy(new BalanceAccountStrategy());

        account.TransactTo(10);

        int actual = account.getBalance();
        int expected = -10;

        assertEquals(expected, actual);
    }

}

