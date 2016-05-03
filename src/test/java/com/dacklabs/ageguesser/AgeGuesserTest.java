package com.dacklabs.ageguesser;

import org.junit.Test;

import static com.dacklabs.ageguesser.HintDirection.HIGHER;
import static com.dacklabs.ageguesser.HintDirection.LOWER;
import static org.junit.Assert.*;

public class AgeGuesserTest {

    @Test
    public void ageGuesserAlwaysStartsAt50() {
        AgeGuesser guesser = new AgeGuesser();

        int guess = guesser.guess();

        assertEquals("Guess was not 50!", 50, guess);
    }

    @Test
    public void ageGuesserHalfsEachGuessAfterLowerHint() {
        AgeGuesser guesser = new AgeGuesser();

        guesser.addHint(LOWER);
        assertEquals(25, guesser.guess());

        guesser.addHint(LOWER);
        assertEquals(12, guesser.guess());

        guesser.addHint(LOWER);
        assertEquals(6, guesser.guess());
    }

    @Test
    public void ageGuesserCountsTheNumberOfHintsItGets() {
        AgeGuesser guesser = new AgeGuesser();

        assertEquals(0, guesser.hintsReceived());

        guesser.addHint(LOWER);
        assertEquals(1, guesser.hintsReceived());

        guesser.addHint(HIGHER);
        assertEquals(2, guesser.hintsReceived());
    }
}