package kartushynaA.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginingWin extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Welcome");
        Parent grid = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
