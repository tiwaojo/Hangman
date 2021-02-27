package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HangmanController implements Initializable {
    private final Hangman hangman = new Hangman();
    private final int LIVES = 7;
    public File file = new File("src/resources/Phrases and Words.txt");
    public ArrayList<String> phraseList = new ArrayList<String>();
    private int count = 0;

    @FXML
    private Text lives;

    @FXML
    private FlowPane flowPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lives.setText(String.valueOf(LIVES));
        readPhraseFromFile(file, phraseList);
        Random random = new Random();
        hangman.setPhrase(phraseList.get(random.nextInt(phraseList.size())));
        String phrase = hangman.getPhrase();
        parsePhrasetoUI(phrase);

        System.out.println("Hangman phrase is: " + phrase);
    }

    private void parsePhrasetoUI(String phrase) {
        //Parses the phrase into individual textfields on the UI
        for (char c : phrase.toCharArray()) {

            TextField textField = new TextField();
            textField.setId(String.valueOf(c));
            textField.setPrefWidth(26);
            textField.setPrefHeight(26);
            textField.setEditable(false);

            if (c == ' ') {
                count++;
                textField.setPrefWidth(16);
                textField.setPrefHeight(16);
                textField.setVisible(false);
            }
            flowPane.getChildren().add(textField);
        }


    }

    public void readPhraseFromFile(File file, ArrayList<String> list) {
        //read each line of the txt file and set it to a phrase list the hangman phrase can pick from
        try {
            Scanner line;
            line = new Scanner(file);

            while (line.hasNext()) {
                //System.out.println(line.nextLine());
                list.add(line.nextLine());
            }
            line.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void isCharExist(MouseEvent event) {
        //On the char button click event isCharExist will determine if the player wins or looses depending on
        //several characteristics, such as num of lives and correct values inputted. isCharExist will also update the UI depending on the input
        if (hangman.getLIVES() >= 0 && count < flowPane.getChildren().size()) {
            Button bttn;
            bttn = (Button) event.getSource();
            lives.setText(String.valueOf(hangman.getLIVES()));

            System.out.println(bttn.getText());
            flowPane.getChildren().forEach(node -> {
                if (bttn.getText().equalsIgnoreCase(node.getId())) {
                    ((TextField) node).setText(bttn.getText());
                    count++;
                }
            });
            if (!hangman.verifyCharinPhrase(bttn.getText(), hangman.getPhrase())) {
                hangman.setLIVES(hangman.getLIVES() - 1);
                System.out.println(lives.getText());
            }
            bttn.setDisable(true);
            if (count >= flowPane.getChildren().size()) {
                //if The boxes are full and phrase has been discovered, player has won
                gameResults("Winner");
                System.out.println("Winner");
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            }
        } else {
            gameResults("Looser");
            System.out.println("Looser");
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        }
    }

    public void gameResults(String results) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(results + " Message");
        if (results.equalsIgnoreCase("Looser")) {
            alert.setContentText("Better Luck next time.\nThe phrase was: \" " + hangman.getPhrase() + "\"");
        } else {
            alert.setContentText("Well done.\nThe phrase was: \" " + hangman.getPhrase() + "\"");
        }
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}
