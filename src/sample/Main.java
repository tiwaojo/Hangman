package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hangman.fxml"));
        primaryStage.setTitle("Hangman");


//        StackPane layout = new StackPane();
//        //layout.getBackground();
//        layout.getChildren().addAll(button);

        Scene primaryScene = new Scene(root);
        primaryScene.getStylesheets().add("/styles.css");
        primaryStage.setScene(primaryScene);
        primaryStage.show();        
    }


    public static void main(String[] args) {
        launch(args);
        //Everything above is setup code. Came with initializing the project. 
    }
}
