package sample;


//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class HangmanControllerTest {
    public final File file = new File("src/resources/testList.txt");
    public final ArrayList<String> testList = new ArrayList<String>();
    final Hangman hangman = new Hangman();
    final HangmanController hangmanController = new HangmanController();

    @Before
    public void setUp() {
        hangmanController.readPhraseFromFile(file, hangmanController.phraseList);
        Random random = new Random();
        hangman.setPhrase(hangmanController.phraseList.get(random.nextInt(hangmanController.phraseList.size())));
        {
            testList.add("suit");
            testList.add("nursery");
            testList.add("decrease");
            testList.add("monstrous");
            testList.add("A Fool and His Money are Soon Parted");
            testList.add("I Smell a Rat");
            testList.add("Jumping the Gun");
            testList.add("raise");
            testList.add("Ugly Duckling");
            testList.add("What Goes Up Must Come Down");
            testList.add("Off One's Base");
            testList.add("incredible");
            testList.add("Down For The Count");
            testList.add("Not the Sharpest Tool in the Shed");
            testList.add("Heads Up");
        }
    }


    @Test
    public void readPhraseFromFile() {
        assertArrayEquals(testList.toArray(), hangmanController.phraseList.toArray());
    }
}