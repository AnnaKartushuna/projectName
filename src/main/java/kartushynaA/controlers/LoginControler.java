package kartushynaA.controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Created by Анна on 22.05.2017.
 */
public class LoginControler {

    @FXML private Text actiontarget;

    @FXML
    public void onButtonClick(ActionEvent event){
        actiontarget.setText("Sign in button pressed");
        System.out.println("Button");
    }
}
