package lk.sipsewanaInstitute.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.sipsewanaInstitute.AppInitializer;

import java.io.IOException;

public class LoginPageController {
    public JFXTextField txtusername;
    public JFXPasswordField txtpassword;
    public AnchorPane loginRoot;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtusername.getText().equalsIgnoreCase("admin") && txtpassword.getText().equalsIgnoreCase("1234")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Welcome to Sipsewana Institute ").show();
            setUi("MainPage");


        } else {
            new Alert(Alert.AlertType.WARNING, "Please check your Username and Password").show();
            clearloginOnAction(null);
        }

    }

    public void clearloginOnAction(ActionEvent actionEvent) {
        txtusername.clear();
        txtpassword.clear();

    }

    private void setUi(String location) throws IOException {
        location = "MainPage";
        loginRoot.getChildren().clear();
        loginRoot.getChildren().add(FXMLLoader.load(AppInitializer.class.getResource("view/" + location + ".fxml")));
    }

    public void onActionUsername(ActionEvent actionEvent) {
        txtpassword.requestFocus();
    }

}
