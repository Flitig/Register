package com.flitig;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        IRegister register = new Register(new AccountBuilder(), new TreeMap<>());
    }
}
