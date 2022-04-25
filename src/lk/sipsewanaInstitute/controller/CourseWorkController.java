package lk.sipsewanaInstitute.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.sipsewanaInstitute.bo.BOFactory;
import lk.sipsewanaInstitute.bo.custom.ProgramBO;
import lk.sipsewanaInstitute.dto.ProgramDTO;
import lk.sipsewanaInstitute.dto.StudentDTO;
import lk.sipsewanaInstitute.tm.ProgramTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CourseWorkController implements Initializable {
    public AnchorPane ProgramRoot;
    public JFXTextField txtproId;
    public JFXTextField txtproduration;
    public JFXTextField txtprofees;
    public JFXTextField txtproname;
    public TableView<ProgramTM> protb;
    public TableColumn proIdtb;
    public TableColumn pronametb;
    public TableColumn durationtb;
    public TableColumn fesstb;
    public TableColumn durationtb1;

    ProgramBO programBO = (ProgramBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.PROGRAM);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initzializ the table customer
        protb.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("programid"));
        protb.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("programname"));
        protb.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        protb.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fees"));


        //get selected row to textField
        protb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtproId.setText(newValue.getProgramId());
            txtproname.setText(newValue.getProgramName());
            txtproduration.setText(newValue.getDuration());
            txtprofees.setText(newValue.getFees());

        });

        //getALLCustomer details
        getAllProgramData();

    }

    private void getAllProgramData() {
        try {
            ArrayList<ProgramDTO> allProgram = programBO.getAllProgram();

            ObservableList<ProgramTM> list = FXCollections.observableArrayList();
            for (ProgramDTO s : allProgram) {
                list.add(new ProgramTM(s.getProgramId(), s.getProgramName(), s.getDuration(), s.getFees()));
            }
            protb.setItems(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onActionProId(ActionEvent actionEvent) {
        txtproname.requestFocus();
    }

    public void onActionDuration(ActionEvent actionEvent) {
        txtprofees.requestFocus();
    }

    public void onActionProName(ActionEvent actionEvent) {
        txtproduration.requestFocus();
    }

    public void updateProgramBtn(ActionEvent actionEvent) {
        try {
            boolean updateprogram = programBO.updateProgram(new ProgramDTO(txtproId.getText(), txtproname.getText(), txtproduration.getText(),
                    txtprofees.getText()));

            if (updateprogram) {
                new Alert(Alert.AlertType.CONFIRMATION, "Program Updated Successfully!!!!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Program updated UnSuccessfully!!!!", ButtonType.OK).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleaerProgramOnAction(null);

        getAllProgramData();

    }

    public void addProgramBtn(ActionEvent actionEvent) {
        try {
            boolean addProgram = programBO.addProgram(new ProgramDTO(txtproId.getText(), txtproname.getText(), txtproduration.getText(),
                    txtprofees.getText()));

            if (addProgram) {
                new Alert(Alert.AlertType.CONFIRMATION, "Program Added Successfully!!!!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Program Added UnSuccessfully!!!!", ButtonType.OK).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleaerProgramOnAction(null);

        getAllProgramData();
    }

    public void deleteaddProgramBtn(ActionEvent actionEvent) {

        try {
            boolean deleteProgram = programBO.deleteProgram(txtproId.getText());
            if (deleteProgram) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item delete Successfully!!!!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Item delete UnSuccessfully!!!!", ButtonType.OK).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleaerProgramOnAction(null);

        getAllProgramData();

    }


    public void backBtn(ActionEvent actionEvent) throws IOException {
        setUi("MainPage");
    }

    private void setUi(String location) throws IOException {
        ProgramRoot.getChildren().clear();
        ProgramRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location + ".fxml")));

    }

    public void cleaerProgramOnAction(ActionEvent actionEvent) {
        txtproId.clear();
        txtproname.clear();
        txtproduration.clear();
        txtprofees.clear();
    }

    public void searchbtn(ActionEvent actionEvent) {
        try {
            ProgramDTO programDTO = programBO.searchProgram(txtproId.getText());
            if (programDTO != null) {
                txtproId.setText(programDTO.getProgramId());
                txtproname.setText(programDTO.getProgramName());
                txtproduration.setText(programDTO.getDuration());
                txtprofees.setText(programDTO.getFees());

            } else {
                new Alert(Alert.AlertType.ERROR, "Program Can't found!!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
