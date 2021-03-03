package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class TitleController {

    @FXML
    private Button registerStageButton;
    @FXML
    private Button loginStageButton;
    @FXML
    private Button closeButton;

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerStageButtonOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void loginStageButtonOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
