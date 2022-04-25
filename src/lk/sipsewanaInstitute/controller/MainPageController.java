package lk.sipsewanaInstitute.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.sipsewanaInstitute.bo.BOFactory;
import lk.sipsewanaInstitute.bo.custom.ProgramBO;
import lk.sipsewanaInstitute.bo.custom.RegistrationDetailsBO;
import lk.sipsewanaInstitute.bo.custom.StudentBO;
import lk.sipsewanaInstitute.dto.ProgramDTO;
import lk.sipsewanaInstitute.dto.StudentDTO;
import lk.sipsewanaInstitute.tm.RegistrationDetailsTM;

import java.io.IOException;
import java.sql.SQLException;

public class MainPageController {
    public AnchorPane mainpageRoot;
    public AnchorPane menuRoot;
    public AnchorPane mainbodyRoot;
    public JFXTextField stuName;
    public JFXTextField txtstuId;
    public JFXTextField txtproId;
    public JFXTextField programname;
    public JFXTextField duration;
    public JFXTextField fees;
    public JFXTextField txtcurrentpayment;
    public TableView<RegistrationDetailsTM> programtb;
    public TableColumn tbproId;
    public TableColumn tbstudentId;
    public TableColumn tbDate;
    public TableColumn tbTime;
    public JFXTextField balance;
    public Label lblRegNo;
    /*StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.STUDENT);
    ProgramBO  programBO = (ProgramBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.PROGRAM);
    RegistrationDetailsBO registrationDetailsBO = (RegistrationDetailsBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.REGISTRATIONDETAILS);
*/
    public void StudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StudentPage");

    }

    public void SubjectOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseWork");
    }

    public void LogoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginPage");
    }

   /* public void stuIdOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO studentDTO = studentBO.searchStudent(txtstuId.getText());
            if (studentDTO != null) {
                stuName.setText(studentDTO.getName());

            } else {
                new Alert(Alert.AlertType.WARNING, "please select a row").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtproId.requestFocus();
    }

    public void proIdOnAction(ActionEvent actionEvent) {
        try {
            ProgramDTO programDTO = programBO.searchProgram(txtproId.getText());
            if (programDTO != null) {
                programname.setText(programDTO.getProgramName());
                duration.setText(programDTO.getDuration());
                fees.setText(programDTO.getFees());

            } else {
                new Alert(Alert.AlertType.WARNING, "please select a row").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtcurrentpayment.requestFocus();
    }


    public void txtcurrentpaymentOnAction(ActionEvent actionEvent) {
        balance.requestFocus();
    }

    public void addtoCartOnAction(ActionEvent actionEvent) {
    }

    public void enterPaymentOnAction(ActionEvent actionEvent) {
    }*/
    private void setUi(String location) throws IOException {
        mainpageRoot.getChildren().clear();
        mainpageRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location + ".fxml")));
    }

    public void stuIdOnAction(ActionEvent actionEvent) {
    }

    public void proIdOnAction(ActionEvent actionEvent) {
    }

    public void txtcurrentpaymentOnAction(ActionEvent actionEvent) {
    }

    public void addtoCartOnAction(ActionEvent actionEvent) {
    }

    public void enterPaymentOnAction(ActionEvent actionEvent) {
    }
   /* private void generateOrderId() {

        try {
            String lastOrderId = orderBO.getLastOrderId();

            if (lastOrderId != null) {
                lastOrderId = lastOrderId.split("[A-Z]")[1];
                if (Integer.parseInt(lastOrderId) < 9) {
                    lastOrderId = "O00" + (Integer.parseInt(lastOrderId) + 1);
                    lbOrder.setText(lastOrderId);
                } else if (Integer.parseInt(lastOrderId) < 100) {
                    lastOrderId = "O0" + (Integer.parseInt(lastOrderId) + 1);
                    lbOrder.setText(lastOrderId);
                }
            } else {
                lbOrder.setText("O001");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
