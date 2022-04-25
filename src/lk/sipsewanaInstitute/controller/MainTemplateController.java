package lk.sipsewanaInstitute.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainTemplateController {
    public AnchorPane mainRoot;
    public AnchorPane headRoot;
    public AnchorPane BodyRoot;
    public Label currentDate;
    public Label currentTime;

    public void initialize() throws IOException {
        loadDefault();

        genarateTime();

        generateCurrentDate();
    }
    private void generateCurrentDate() {
        currentDate.setText(LocalDate.now().toString());
    }

    private void genarateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e ->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentTime.setText(LocalTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        currentTime.setText(LocalDate.now().toString());
    }

    private void loadDefault() throws IOException {
        setUi("Loginpage");
    }
    private void setUi(String location) throws IOException {
        BodyRoot.getChildren().clear();
        BodyRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location + ".fxml")));
    }

}
