package sample;

//Hangman class consisting of getter and setter methods as well as a boolean check for whether a character(a string cause of javafx)
//exists in the phrase
public class Hangman {
    private int LIVES = 7;
    private String phrase;

    public int getLIVES() {
        return LIVES;
    }

    public void setLIVES(int LIVES) {
        this.LIVES = LIVES;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public boolean verifyCharinPhrase(String c, String phrase) {
        //converts both the phrase and character from the button click to lower case before comparing
        return phrase.toLowerCase().contains(c.toLowerCase());
    }

}
