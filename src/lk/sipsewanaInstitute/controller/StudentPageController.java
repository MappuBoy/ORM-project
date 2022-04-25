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
import lk.sipsewanaInstitute.bo.custom.StudentBO;
import lk.sipsewanaInstitute.dto.StudentDTO;
import lk.sipsewanaInstitute.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {
    public AnchorPane studentRoot;
    public JFXTextField stuIdtxt;
    public JFXTextField txtemail;
    public JFXTextField txtNiC;
    public JFXTextField txtTpNumber;
    public JFXTextField txtAddress;
    public JFXTextField txtName;
    public TableView<StudentTM> studetntb;
    public TableColumn stuIdtb;
    public TableColumn stuNametb;
    public TableColumn stuAddresstb;
    public TableColumn stutpnumbertb;
    public TableColumn stunictb;
    public TableColumn stuemailtb;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initzializ the table customer
        studetntb.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentid"));
        studetntb.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        studetntb.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        studetntb.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("tpnumber"));
        studetntb.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
        studetntb.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("email"));

        //get selected row to textField
        studetntb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            stuIdtxt.setText(newValue.getStudentId());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtTpNumber.setText(newValue.getTpnumber());
            txtNiC.setText(newValue.getNic());
            txtemail.setText(newValue.getEmail());
        });

        //getALLCustomer details
        getAllStudentDetails();

    }

    private void getAllStudentDetails() {
        try {
            ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();

            ObservableList<StudentTM> list = FXCollections.observableArrayList();
            for (StudentDTO s : allStudent) {
                list.add(new StudentTM(s.getStudentId(), s.getName(), s.getAddress(), s.getTpnumber(),
                        s.getNic(), s.getEmail()));
            }
            studetntb.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stuIdonAction(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void nameonAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void nicOnAction(ActionEvent actionEvent) {
        txtemail.requestFocus();
    }

    public void tpnumberOnAction(ActionEvent actionEvent) {
        txtNiC.requestFocus();
    }

    public void stuAddressonAction(ActionEvent actionEvent) {
        txtTpNumber.requestFocus();
    }

    public void addStudentbtn(ActionEvent actionEvent) {
        try {
            boolean addStudent = studentBO.addStudent(new StudentDTO(stuIdtxt.getId(), txtName.getText(), txtAddress.getText(),
                    txtTpNumber.getText(), txtNiC.getText(),
                    txtemail.getText()));

            if (addStudent) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Added Successfully!!!!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Item Added UnSuccessfully!!!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleaerStudentOnAction(null);

        getAllStudentDetails();

    }


    public void updateStdentOnAction(ActionEvent actionEvent) {
        try {
            boolean updateStudent = studentBO.updateStudent(new StudentDTO(stuIdtxt.getId(), txtName.getText(), txtAddress.getText(),
                    txtTpNumber.getText(), txtNiC.getText(),
                    txtemail.getText()));

            if (updateStudent) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Added Successfully!!!!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Item Added UnSuccessfully!!!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleaerStudentOnAction(null);

        getAllStudentDetails();

    }

    public void deleteStudentOnAction(ActionEvent actionEvent) {
        try {
            boolean deleteStudent = studentBO.deleteStudent(stuIdtxt.getText());
            if (deleteStudent) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item delete Successfully!!!!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Item delete UnSuccessfully!!!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cleaerStudentOnAction(null);

        getAllStudentDetails();
    }

    public void Searchstudentbtn(ActionEvent actionEvent) {
        try {
            StudentDTO studentDTO = studentBO.searchStudent(stuIdtxt.getText());
            if (studentDTO != null) {
                stuIdtxt.setText(studentDTO.getName());
                txtName.setText(studentDTO.getName());
                txtAddress.setText(studentDTO.getAddress());
                txtTpNumber.setText(studentDTO.getTpnumber());
                txtNiC.setText(studentDTO.getNic());
                txtemail.setText(studentDTO.getEmail());
            } else {
                new Alert(Alert.AlertType.ERROR, "Item Can't found!!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        setUi("MainPage");
    }

    private void setUi(String location) throws IOException {
        studentRoot.getChildren().clear();
        studentRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location + ".fxml")));

    }

    public void cleaerStudentOnAction(ActionEvent actionEvent) {
        stuIdtxt.clear();
        txtName.clear();
        txtAddress.clear();
        txtTpNumber.clear();
        txtNiC.clear();
        txtemail.clear();
    }


}
