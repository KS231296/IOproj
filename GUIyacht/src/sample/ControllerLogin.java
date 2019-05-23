/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Kinu
 */
public class ControllerLogin extends Controller{
    
     @FXML
    private TextField txtLogin;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;
    
    
     @FXML
    void login(ActionEvent event) {
        System.out.println(txtLogin.getText() + txtPassword.getText());
        if (txtLogin.getText().equals("owner") && txtPassword.getText().equals("owner")) {
            newScene(event, "ownerView.fxml", 600, 320);
        }

    }

    @FXML
    public void enter(KeyEvent e) {

        if (e.getCode() == KeyCode.ENTER) {
            btnLogin.fire();
        }
    }
    
    
    
}
