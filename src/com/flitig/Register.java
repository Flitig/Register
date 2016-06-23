package com.flitig;

import java.util.TreeMap;

/**
 * Created by Flitig on 2016-06-23.
 */
public class Register implements IRegister {
    private final AccountBuilder accountBuilder;
    private final TreeMap<String, IAccount> accounts;

    public Register(AccountBuilder accountBuilder, TreeMap<String, IAccount> accounts) {
        this.accountBuilder = accountBuilder;
        this.accounts = accounts;
    }

    @Override
    public String[] Run(String[] input) {
        if (input.length == 0) {
            return new String[]{"(no accounts)"};
        } else {
            String[] tmp;

            for (String s : input) {
                tmp = s.split("\\s+", 4);
                if (tmp[0].equals("add")) {
                    IAccount account = accountBuilder.CreateAccount(tmp[1], tmp[3]);
                    accounts.put(tmp[3], account);
                } else {
                    String fromAccountName = tmp[1].split(":")[1];
                    String toAccountName = tmp[2].split(":")[1];
                    IAccount fromAccount = accounts.get(fromAccountName);
                    IAccount toAccount = accounts.get(toAccountName);
                    int amount = Integer.parseInt(tmp[3]);

                    Transact(fromAccount, toAccount, amount);
                }
            }

            String[] array = accounts.values().stream().map(Object::toString).toArray(String[]::new);
            return array;
        }

    }

    private void Transact(IAccount fromAccount, IAccount toAccount, int amount) {
        toAccount.TransactTo(amount);
        fromAccount.TransactFrom(amount);
    }
}
