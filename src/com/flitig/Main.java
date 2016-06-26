package com.flitig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        IRegister register;
        BufferedReader br;
        Stream<String> stream;
        String[] output;

        register = new Register(new AccountBuilder(), new TreeMap<>());

        br = new BufferedReader(new InputStreamReader(System.in));
        stream = br.lines();
        output = register.Run(stream.toArray(String[]::new));

        Arrays.stream(output).forEach(System.out::println);
    }
}
