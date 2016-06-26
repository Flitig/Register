package com.flitig;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Flitig on 2016-06-23.
 */
public class SystemTests {
    @Test
    public void TestsEmptyInput() throws Exception {
        IRegister register = new Register(new AccountBuilder(), new TreeMap<>());
        String[] input = new String[]{};
        String[] expected = new String[]{"(no accounts)"};
        String[] actual = register.Run(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void TestsAdding() throws Exception {
        IRegister register = new Register(new AccountBuilder(), new TreeMap<>());
        String[] input = new String[]{
                "add check account Bankkonto",
                "add expense account Livsmedel",
                "add expense account Hyra",
                "add income account Inkomst"
        };
        String[] expected = new String[]{
                "Bankkonto:0",
                "Hyra:0",
                "Inkomst:0",
                "Livsmedel:0"
        };
        String[] actual = register.Run(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestsAddingAndTransacting() throws Exception {
        IRegister register = new Register(new AccountBuilder(), new TreeMap<>());
        String[] input = new String[]{
                "add check account Bankkonto",
                "add expense account Livsmedel",
                "add expense account Hyra",
                "add income account Inkomst",
                "transaction from:Inkomst   to:Bankkonto 1000",
                "transaction from:Bankkonto to:Livsmedel 50",
                "transaction from:Bankkonto to:Hyra      250",
                "transaction from:Inkomst   to:Bankkonto 1000",
                "transaction from:Bankkonto to:Hyra      250"
        };
        String[] expected = new String[]{
                "Bankkonto:1450",
                "Hyra:-500",
                "Inkomst:2000",
                "Livsmedel:-50"};
        String[] actual = register.Run(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestsCorrectingTransaction() throws Exception {
        IRegister register = new Register(new AccountBuilder(), new TreeMap<>());
        String[] input = new String[]{
                "add check account Bankkonto",
                "add expense account Livsmedel",
                "add expense account Hyra",
                "add income account Inkomst",
                "transaction from:Inkomst   to:Bankkonto 1000",
                "transaction from:Bankkonto to:Hyra      100",
                "transaction from:Hyra      to:Livsmedel 100",
        };
        String[] expected = new String[]{
                "Bankkonto:900",
                "Hyra:0",
                "Inkomst:1000",
                "Livsmedel:-100"};
        String[] actual = register.Run(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestsAddingAccountWithLongName() throws Exception {
        IRegister register = new Register(new AccountBuilder(), new TreeMap<>());
        String[] input = new String[]{
                "add check account Bankkonto",
                "add expense account Livsmedel och luncher på stan"
        };
        String[] expected = new String[]{
                "Bankkonto:0",
                "Livsmedel och lunche:0"
        };
        String[] actual = register.Run(input);

        assertArrayEquals(expected, actual);
    }
}