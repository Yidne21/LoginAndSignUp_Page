import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class WkuloginController {
    Pane pane = new Pane();

    @FXML
    private Button btnSignUpId;

    @FXML
    private Button btnloginId;

    @FXML
    private PasswordField passwordTfID;

    @FXML
    TextField emailTF;

    Boolean authenthicBoolean = false;
    SceneController Switch = new SceneController();

    @FXML
    void btnLoginClicked(ActionEvent event) {
        btnloginId.setOnAction(e -> {
            StudentQueries queries = new StudentQueries();
            if (emailTF.getText() != null && passwordTfID.getText() != null) {
                try {
                    authenthicBoolean = queries.Login(emailTF.getText(), passwordTfID.getText());
                    if (authenthicBoolean == true) {
                        Switch.switchToDashbored(event);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Please provide your email and password");
                alert.show();
            }
        });
    }

    @FXML
    void btnSignUpClicked(ActionEvent event) {
        btnSignUpId.setOnAction(e -> {
            try {
                Switch.switchPanes(event);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

}
