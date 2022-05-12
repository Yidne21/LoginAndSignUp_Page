import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DashboaredController {

    SceneController Switch = new SceneController();

    @FXML
    Button btnlogout;

    @FXML
    VBox dbordvbox;

    @FXML
    Label emailLabel;

    @FXML
    Label fnamelabel;

    @FXML
    Label lnamelabel;

    public void display(String fname, String lname, String email) {
        fnamelabel.setText(fname);
        lnamelabel.setText(lname);
        emailLabel.setText(email);
    }

    @FXML
    void btnlogoutCliked(ActionEvent event) {
        btnlogout.setOnAction(e -> {
            try {
                Switch.switchToLogin(event);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

}
