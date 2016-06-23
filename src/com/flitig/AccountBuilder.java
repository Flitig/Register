package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public class AccountBuilder {
    public IAccount CreateAccount(String type, String name) {
        IAccount account = new Account(name);
        if (type.equals("check")) {
            account.SetAccountTypeStrategy(new CheckAccountStrategy());

        } else {
            account.SetAccountTypeStrategy(new BalanceAccountStrategy());
        }
        return account;
    }
}
