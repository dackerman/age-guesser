package com.dacklabs.ageguesser;

public class AgeGuesserUI {
    private final ConsoleIO io;
    private final AgeGuesser guesser;

    public AgeGuesserUI(ConsoleIO io, AgeGuesser guesser) {
        this.io = io;
        this.guesser = guesser;
    }

    public void start() {
        io.printLine("I will guess your age, and you tell me if it was higher, lower, or yes.");
        boolean correct = false;
        while (!correct) {
            int guess = guesser.guess();
            io.printLine(String.format("Are you %d years old? (possible answers: higher, lower, yes)", guess));
            String answer = io.getUserInput().toLowerCase();

            if (answer.contains("higher")) {
                guesser.addHint(HintDirection.HIGHER);
            } else if (answer.contains("lower")) {
                guesser.addHint(HintDirection.LOWER);
            } else if (answer.contains("yes")) {
                correct = true;
            } else {
                io.printLine(String.format("I didn't understand \"%s\". Try again", answer));
            }
        }
        io.printLine(String.format("Hooray! I only needed %d hints!", guesser.hintsReceived()));
    }
}
