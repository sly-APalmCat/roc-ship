package com.rocship.aligenerator;

import org.apache.commons.lang.WordUtils;

public class WoMan implements Po{

    @Override
    public void say() {
        System.out.println(WordUtils.capitalize("i am woMan"));
    }
}