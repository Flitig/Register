package com.flitig;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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

}