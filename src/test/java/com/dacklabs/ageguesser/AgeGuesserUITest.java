package com.dacklabs.ageguesser;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgeGuesserUITest {

    @Test
    public void uiGuessesAgeAndCelebratesIfCorrect() {
        FakeIO io = new FakeIO("yes");
        AgeGuesser guesser = new AgeGuesser();

        AgeGuesserUI ui = new AgeGuesserUI(io, guesser);
        ui.start();

        assertEquals(3, io.output.size());

        String expectedFirstLine = "I will guess your age";
        String expectedSecondLine = String.format("Are you %d years old? ", guesser.guess());
        String expectedThirdLine = "Hooray! I only needed 0 hints";

        assertTrue("first message wasn't instructions",
                io.output.get(0).contains(expectedFirstLine));

        assertTrue("second message doesn't contain the guess",
                io.output.get(1).contains(expectedSecondLine));

        assertTrue("third message doesn't contain a count of guesses",
                io.output.get(2).contains(expectedThirdLine));
    }

    @Test
    public void uiKeepsGuessingAgeUntilCorrect() {
        FakeIO io = new FakeIO("higher", "lower", "yes");

        AgeGuesserUI ui = new AgeGuesserUI(io, new AgeGuesser());
        ui.start();

        assertEquals(5, io.output.size());

        String ageQuestionRegex = "Are you \\d+ years old.*";

        assertTrue(io.output.get(1).matches(ageQuestionRegex));
        assertTrue(io.output.get(2).matches(ageQuestionRegex));
        assertTrue(io.output.get(3).matches(ageQuestionRegex));
    }

    @Test
    public void uiTellsUserWhenItGetsAnInvalidCommandAndContinues() {
        FakeIO io = new FakeIO("aljsfl;kasjdf", "yes");

        AgeGuesserUI ui = new AgeGuesserUI(io, new AgeGuesser());
        ui.start();

        assertEquals(5, io.output.size());

        String secondLine = io.output.get(2);
        String expectedSecondLine = "I didn't understand \"aljsfl;kasjdf\"";
        String lastLine = io.output.get(4);

        assertTrue("Expected invalid command message but got " + secondLine, secondLine.contains(expectedSecondLine));
        assertTrue("Expected Hooray but got " + lastLine, lastLine.contains("Hooray!"));
    }

}