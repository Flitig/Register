package com.flitig;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Flitig on 2016-06-23.
 */
public class SystemTest {
    @Test
    public void TestsEmptyInput() throws Exception {
        IRegister register = new Register();
        String[] input = new String[]{};
        String[] expected = new String[]{"(no accounts)"};
        String[] actual = register.Run(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void TestsAdding() throws Exception {
        IRegister register = new Register();
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
        IRegister register = new Register();
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
}




