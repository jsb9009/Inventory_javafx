package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.UserDAO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by jaliya on 12/29/17.
 */
public class EditUserController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField password;
    @FXML
    private ComboBox<String> role;
    @FXML
    private TextField contactNo;
    @FXML
    private TextArea address;
    @FXML
    private Label errorLabel;

    ObservableList<String> newRoleList = FXCollections.observableArrayList("", "Admin", "Operator");

    @FXML
    private void initialize() throws SQLException, ParseException {


        role.setItems(newRoleList);
        UserController uc = new UserController();
        //password.setText(uc.editablePassword);
        firstName.setText(uc.editableFirstName);
        lastName.setText(uc.editableLastName);
        role.setValue(uc.editableRole);
        contactNo.setText(uc.editableContactNo);
        address.setText(uc.editableAddress);
    }



    @FXML
    public void fieldsClear(ActionEvent actionEvent) {
        firstName.clear();
        lastName.clear();
        password.clear();
        password.clear();
        role.setValue("");
        contactNo.clear();
        address.clear();
    }

    @FXML
    public void clear() {
        firstName.clear();
        lastName.clear();
        password.clear();
        password.clear();
        role.setValue("");
        contactNo.clear();
        address.clear();
        errorLabel.setText("");
    }


    @FXML
    private void updateUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, FileNotFoundException {


        UserController uc = new UserController();
        int id = Integer.parseInt(uc.editableUserId);

        if (validateInput()&&validatePassword()) {
            try {

                UserDAO.updateUser(id, firstName.getText(), lastName.getText(), role.getValue().toString(), password.getText(), contactNo.getText(), address.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User update");
                alert.setHeaderText("Success message");
                alert.setContentText("The user was successfully updated!!");
                alert.showAndWait();
                errorLabel.setText("");
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("User delete");
                alert.setHeaderText("Failure message");
                alert.setContentText("Problem occurred while updating user " + e);
                alert.showAndWait();
            }
        }
    }

    private boolean validateInput() {
        String errorMessage = "";
        if (!(firstName.getText() == null || firstName.getText().length() == 0 || lastName.getText() == null || lastName.getText().length() == 0 || role.getValue() == null || role.getValue().length() == 0 || contactNo.getText() == null || contactNo.getText().length() == 0 || address.getText() == null || address.getText().length() == 0)) {

            if (firstName.getText().matches("^[a-zA-Z\\s]+") && lastName.getText().matches("^[a-zA-Z\\s]+") && role.getValue().toString().matches("^[a-zA-Z\\s]+") && contactNo.getText().matches("^[0-9]{10,15}$") && address.getText().matches("^[A-Za-z0-9\\s\\-_,-]+$")) {
                return true;
            } else {
                errorMessage += "Invalid input entered!!\n";
                errorLabel.setText(errorMessage);
            }
            return false;
        }
        errorMessage += "Please fill all required fields!\n";
        errorLabel.setText(errorMessage);
        return false;
    }


    private boolean validatePassword() {
        String errorMessage = "";
        if (!(password.getText() == null || password.getText().length() == 0)) {

            if (password.getText().matches("^[A-Za-z0-9\\s\\-#%$*&@!_,-]+$")) {
                return true;
            } else {
                errorMessage += "Invalid characters in the password!!\n";
                errorLabel.setText(errorMessage);
            }
            return false;
        }
        errorMessage += "Please enter the password to change details!\n";
        errorLabel.setText(errorMessage);
        return false;
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) firstName.getScene().getWindow();
        stage.close();
    }
}
