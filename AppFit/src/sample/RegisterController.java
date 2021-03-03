package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterController {

    @FXML
    private Button closeButton;
    @FXML
    private Label registerSuccessLabel;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private Button registerButton;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private PasswordField passwordConfirm;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;




    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerButtonOnAction(ActionEvent event) {
        if (registerPasswordField.getText().equals(passwordConfirm.getText())) {
            registerUser();
            confirmPasswordLabel.setText("");
        } else {
            confirmPasswordLabel.setText("Passwords do not match");
        }
    }

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConenction();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = registerPasswordField.getText();

        String insertFields = "INSERT INTO user_account(firstname, lastname, username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname +"','" + username +"','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            registerSuccessLabel.setText("User has been registered successfully!");
        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
