package sample;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HangmanTest {
    Hangman hangman =new Hangman();

    @Before
    public void setUp() {
        HangmanControllerTest hangmanControllerTest = new HangmanControllerTest();
        hangmanControllerTest.setUp();
    }

    @Test
    public void getLIVES() {
        assertEquals(7,hangman.getLIVES());
    }

    @Test
    public void getPhrase() {
        assertNull(hangman.getPhrase());
    }

    @Test
    public void verifyCharinPhrase() {
        assertTrue(hangman.verifyCharinPhrase("g","Hangman"));
    }
}