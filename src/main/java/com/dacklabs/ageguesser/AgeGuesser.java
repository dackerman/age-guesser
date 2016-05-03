package com.dacklabs.ageguesser;

import static com.dacklabs.ageguesser.HintDirection.HIGHER;

public class AgeGuesser {
    private int lowerBound = 0;
    private int upperBound = 100;
    private int hints = 0;

    public int guess() {
        int range = upperBound - lowerBound;
        return range / 2 + lowerBound;
    }

    public void addHint(HintDirection direction) {
        hints++;
        int lastGuess = guess();
        if (HIGHER.equals(direction)) {
            lowerBound = lastGuess;
        } else {
            upperBound = lastGuess;
        }
    }

    public int hintsReceived() {
        return hints;
    }
}
