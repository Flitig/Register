package com.flitig;

/**
 * Created by Flitig on 2016-06-23.
 */
public class Register implements IRegister {
    @Override
    public String[] Run(String[] input){
        if (input.length == 0){
            return new String[]{"(no accounts)"};
        }

        else {
            return new String[]{"Bankkonto:0", "Hyra:0", "Inkomst:0", "Livsmedel:0"};
        }

    }
}
