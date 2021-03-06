package com.dacklabs.ageguesser;

import java.util.Scanner;

public final class SysIO implements ConsoleIO {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void printLine(String line) {
        System.out.println(line);
    }
}
