/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Kinu
 */
public class ControllerOwnerView extends Controller {
 
    private String yachtProp;
    private String clientProp;
    private String reservationProp;
    
    @FXML
    private Text txtTesty;

    @FXML
    private Button btnClient;

    @FXML
    private Button btwRes;

    @FXML
    private Button add;

    @FXML
    private TextField nameBox;

    @FXML
    private TextField typeBox;

    @FXML
    private TextField lengthBox;

    @FXML
    private TextField pplBox;

    @FXML
    private TextField engBox;

    @FXML
    private TextField sailBox;

    @FXML
    private TextField idBox;
    
    
    @FXML
    private CheckBox yachtsRemoveCheck;

    @FXML
    private CheckBox yachtsModifCheck;

    @FXML
    private CheckBox yachtAddCheck;

    @FXML
    private Button manageClientBtn;

    @FXML
    private CheckBox clientAddCheck;

    @FXML
    private CheckBox clientRemoveCheck;

    @FXML
    private CheckBox clientModifCheck;

    @FXML
    private TextField yachtModProp;

    @FXML
    private Text propYachtText;
    
     @FXML
    public void initialize(URL location, ResourceBundle resources) {
        yachtModProp.setVisible(false);
        propYachtText.setVisible(false);
         System.out.println("Init");
    }
    
     @FXML
    void showClients(ActionEvent event) {
        showItems(Main.getFac().getClientsData(), event);
        
         if (((Node) (event.getSource())).getScene().getWindow().getHeight() < 700) {
            ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
            ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

        }

    }

    @FXML
    void showReservations(ActionEvent event) {

        showItems(Main.getFac().getReservationsData(), event);
 if (((Node) (event.getSource())).getScene().getWindow().getHeight() < 700) {
            ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
            ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

        }
    }
    
    @FXML
    void onCheckAddYacht(ActionEvent event) {
        yachtModProp.setVisible(false);
        propYachtText.setVisible(false);
        yachtsModifCheck.setSelected(false);
        yachtsRemoveCheck.setSelected(false);
        yachtProp = "add";
        System.out.println("add");
    }

    @FXML
    void onCheckModifYacht(ActionEvent event) {
        yachtModProp.setVisible(true);
        propYachtText.setVisible(true);
        yachtsRemoveCheck.setSelected(false);
        yachtAddCheck.setSelected(false);
        yachtProp = "modif";
        System.out.println("modi");
    }

    @FXML
    void onCheckRemoveYacht(ActionEvent event) {
        yachtModProp.setVisible(false);
        propYachtText.setVisible(false);
        yachtsModifCheck.setSelected(false);
        yachtAddCheck.setSelected(false);
        yachtProp = "remove";
        System.out.println("remove");
    }

    @FXML
    void addYacht(ActionEvent event) {
       
        try {
            Integer.parseInt(idBox.getText());
            Double.parseDouble(lengthBox.getText());
            Integer.parseInt(pplBox.getText());
            Double.parseDouble(engBox.getText());
            Integer.parseInt(sailBox.getText());

        } catch (IllegalArgumentException e) {
            new Alert(Alert.AlertType.ERROR, "Wrong data").show();
            return;
        }
        System.out.println(Main.getFac().getYachts());
        String[] data = {"1", idBox.getText(), nameBox.getText(), typeBox.getText(), lengthBox.getText(), pplBox.getText(), engBox.getText(), sailBox.getText()};
        System.out.println(Arrays.toString(data));
        switch(yachtProp){
            case "add":                
                Main.getFac().addYacht(data);
                break;
            case "modif":
                Main.getFac().modifyYacht(Integer.parseInt(data[1]),yachtModProp.getText(),data[2]);
                break;
            case "remove":
                Main.getFac().deleteYacht(Integer.parseInt(data[1]));
                break;
        }
        System.out.println(Main.getFac().getYachts());

    }
  @FXML
    void addShow(ActionEvent event) {
        Optional<ButtonType> result = new Alert(Alert.AlertType.CONFIRMATION, "Search or show all?", new ButtonType("SEARCH"), new ButtonType("ALL"), ButtonType.CANCEL).showAndWait();

        if (result.isPresent()) {
            if (result.get() == ButtonType.CANCEL) {
                return;
            } else if (result.get().getText().equals("SEARCH")) {
// Szukanie dodać

            } else if (result.get().getText().equals("ALL")) {

                showItems(Main.getFac().getYachtsData(), event);
                
                 if (((Node) (event.getSource())).getScene().getWindow().getHeight() < 700) {
            ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
            ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

        }
            }

        }

    }

  
    
}
