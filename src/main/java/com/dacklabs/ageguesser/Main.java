package com.dacklabs.ageguesser;

public class Main {
    public static void main(String[] args) {
        AgeGuesserUI ui = new AgeGuesserUI(new SysIO(), new AgeGuesser());
        ui.start();
    }
}
