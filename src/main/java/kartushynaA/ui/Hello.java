package kartushynaA.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello!");
        Button button = new Button();
        button.setText(" Say 'Hello' ");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene( root, 300,250));
        primaryStage.show();
    }

}
