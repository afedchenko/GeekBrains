package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ВСЕМ ЧМОКИ Ф ЭТАМ ЧЯТЕ");
        Scene myScene = new Scene(root, 600, 400);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
