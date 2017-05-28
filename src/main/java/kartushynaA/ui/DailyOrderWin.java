package kartushynaA.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Created by Анна on 28.05.2017.
 */
public class DailyOrderWin extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Наряд");
        Parent grid = FXMLLoader.load(getClass().getClassLoader().getResource("view/DailyOrder.fxml"));

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
