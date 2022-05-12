import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SignUpController {
    SceneController Switch = new SceneController();
    StudentQueries queries = new StudentQueries();

    @FXML
    private PasswordField PasswordPF;

    @FXML
    private Button BtnBack;

    @FXML
    private TextField emailTF;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField firstnamTF;

    @FXML
    private TextField lastnameTF;

    @FXML
    private PasswordField passwordAgainPF;

    @FXML
    void btnRegisterCliked(ActionEvent event) {
        btnRegister.setOnAction(e -> {

            if (passwordAgainPF.getText().equals(PasswordPF.getText())) {
                int success;
                success = queries.addStudent(firstnamTF.getText(), lastnameTF.getText(), PasswordPF.getText(),
                        emailTF.getText());
                if (success > 0) {
                    try {
                        Switch.switchToLogin(event);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Please Fill all entry!");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("passwored doesn't match");
                alert.show();
            }
        });
    }

    @FXML
    void btnBackcliked(ActionEvent event) {
        BtnBack.setOnAction(e -> {
            try {
                Switch.switchToLogin(event);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

}
