package com.flitig;

import org.junit.Test;

/**
 * Created by Flitig on 2016-06-23.
 */
public class SystemTest {
    @Test
    public void TestsEmptyInput() throws Exception {
        IRegister register = new com.flitig.Register();
        String[] input = new String[]{""};
        String[] expected = new String[]{"(no accounts)"};
        String[] actual = new String[]{register.Run(input)};
    }

}