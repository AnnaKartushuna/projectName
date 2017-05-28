package kartushynaA.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by Анна on 16.05.2017.
 */
public class StartWin extends Application {

    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        ChoiceBox referenceBooks = new ChoiceBox();
        ChoiceBox create = new ChoiceBox();
        ChoiceBox timeTableForRoute = new ChoiceBox();
        ChoiceBox add = new ChoiceBox();
        ChoiceBox changeDaileOrder = new ChoiceBox();

        create.setItems(FXCollections.observableArrayList(
                "наряд","выходные"
        ));
        timeTableForRoute.setItems(FXCollections.observableArrayList(
                "2","3","5","7","8","9","10","11","12"
        ));




        referenceBooks.setItems(FXCollections.observableArrayList(
                "Водители","Кондукторы","Маршруты"
        ));



        root.getChildren().addAll(referenceBooks,create,timeTableForRoute,add,changeDaileOrder);


        Scene scene = new Scene(root,300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
