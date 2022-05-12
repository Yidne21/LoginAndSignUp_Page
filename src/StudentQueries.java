import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StudentQueries {
    private static final String URL = "jdbc:mysql://localhost/student";
    private static final String USER = "yidne";
    private static final String PASSWORD = "19ybb21";

    private Connection connection;
    private PreparedStatement selectByemail;
    private PreparedStatement getPassworedandEmail;
    private PreparedStatement insertNewStudent;

    StudentQueries() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            selectByemail = connection
                    .prepareStatement(
                            "SELECT firstname, lastname, email FROM studentinfo order by firstname,lastname where email=?");
            insertNewStudent = connection.prepareStatement(
                    "insert into studentinfo (firstname,lastname, email, passw) values (?, ?, ?, ?)");

        } catch (SQLException ex) {

            ex.printStackTrace();
            System.exit(1);
        }

    }

    public int addStudent(String firstName, String lastName, String passws, String email) {

        try {

            insertNewStudent.setString(1, firstName);
            insertNewStudent.setString(2, lastName);
            insertNewStudent.setString(3, email);
            insertNewStudent.setString(4, passws);// make it index 3

            return insertNewStudent.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    boolean Login(String email, String passwored) throws ClassNotFoundException, SQLException {
        boolean validate = false;
        String Ppasswored = null;
        try {
            getPassworedandEmail = connection
                    .prepareStatement("SELECT passw,email FROM studentinfo where email= ?");
            getPassworedandEmail.setString(1, email);
            ResultSet rSet = getPassworedandEmail.executeQuery();
            while (rSet.next()) {
                Ppasswored = rSet.getString("passw");
            }
            if (Ppasswored != null) {
                if (Ppasswored.equals(passwored)) {
                    validate = true;
                    rSet.close();
                } else {
                    validate = false;
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("unknown Email or password please try again");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("unknown Email or password please try again");
                alert.show();
                validate = false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Oops you have inserted invalid input. please try again! ");
        }
        return validate;

    }

    public void getStudentinfo() {
        try {
            ResultSet resultSet = selectByemail.executeQuery();
            while (resultSet.next()) {
                resultSet.getString("firstname");
                resultSet.getString("lastname");
                resultSet.getString("email");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

}
