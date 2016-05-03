package com.dacklabs.ageguesser;

import java.util.Scanner;

import static com.dacklabs.ageguesser.HintDirection.HIGHER;
import static com.dacklabs.ageguesser.HintDirection.LOWER;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("I will guess your age, and you tell me if it was higher, lower, or correct.");
        AgeGuesser guesser = new AgeGuesser();
        boolean correct = false;
        while (!correct) {
            int guess = guesser.guess();
            System.out.println(String.format("Are you %d years old? (possible answers: higher, lower, correct)", guess));
            String answer = scanner.nextLine().toLowerCase();

            if (answer.contains("higher")) {
                guesser.addHint(HIGHER);
            } else if (answer.contains("lower")) {
                guesser.addHint(LOWER);
            } else if (answer.contains("correct")) {
                correct = true;
            } else {
                System.out.println(String.format("I didn't understand \"%s\". Try again", answer));
            }
        }
        System.out.println(String.format("Hooray! I only needed %d hints!", guesser.hintsReceived()));
    }
}
