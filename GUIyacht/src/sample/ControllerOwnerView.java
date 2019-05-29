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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
    private Text propClientText;

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
    private TextField nameBoxClient;

    @FXML
    private TextField surnameBoxClient;

    @FXML
    private TextField phoneBox;

    @FXML
    private TextField idBoxClient;

    @FXML
    private RadioButton yachtsRemoveCheck;

    @FXML
    private RadioButton yachtsModifCheck;

    @FXML
    private RadioButton yachtAddCheck;

    @FXML
    private Button manageClientBtn;

    @FXML
    private RadioButton clientAddCheck;

    @FXML
    private RadioButton clientRemoveCheck;

    @FXML
    private RadioButton clientModifCheck;

    @FXML
    private ChoiceBox<String> yachtModProp;

    @FXML
    private ChoiceBox<String> clientModProp;

    @FXML
    private ChoiceBox<String> reservationModProp;

    @FXML
    private RadioButton yachtsSearchCheck;
    @FXML
    private RadioButton clientSearchCheck;

    @FXML
    private Text propYachtText;

    @FXML
    private ToggleGroup clientsGroup;

    @FXML
    private ToggleGroup yachtsGroup;

    @FXML
    private Button manageReservationsBtn;

    @FXML
    private TextField txtDateStart;

    @FXML
    private TextField txtDateEnd;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtClient;

    @FXML
    private ToggleGroup reservationsGroup;

    @FXML
    public void initialize() {
        yachtModProp.setVisible(false);
        propYachtText.setVisible(false);
        yachtProp = "add";

        clientModProp.setVisible(false);
        propClientText.setVisible(false);
        clientProp = "add";
        yachtsGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton chk = (RadioButton) newValue;
//            System.out.println(chk.getText().toLowerCase());
            yachtProp = chk.getText().toLowerCase();
            if (newValue == yachtsModifCheck) {
                yachtModProp.setVisible(true);
                propYachtText.setVisible(true);
            } else {
                yachtModProp.setVisible(false);
                propYachtText.setVisible(false);
            }
        });

        clientsGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton chk = (RadioButton) newValue;
            clientProp = chk.getText().toLowerCase();
            if (newValue == clientModifCheck) {
                clientModProp.setVisible(true);
                propClientText.setVisible(true);
            } else {
                clientModProp.setVisible(false);
                propClientText.setVisible(false);
            }
        });

        System.out.println("Init");
    }

    @FXML
    void showYachts(ActionEvent event) {

        if (1 == showItems(Main.getFac().getYachtsData(), event)) {
            yachtProp = "search";
            addYacht(event);
            RadioButton chk = (RadioButton) yachtsGroup.getSelectedToggle();
            yachtProp = chk.getText().toLowerCase();

        }

    }

    @FXML
    void showClients(ActionEvent event) {

        if (1 == showItems(Main.getFac().getClientsData(), event)) {
            clientProp = "search";
             manageClient(event);
            RadioButton chk = (RadioButton) clientsGroup.getSelectedToggle();
            clientProp = chk.getText().toLowerCase();
        }

    }

    @FXML
    void showReservations(ActionEvent event) {
        showItems(Main.getFac().getReservationsData(), event);
    }

//    @FXML
//    void onCheckAddYacht(ActionEvent event) {
//        yachtModProp.setVisible(false);
//        propYachtText.setVisible(false);
//        yachtsModifCheck.setSelected(false);
//        yachtsRemoveCheck.setSelected(false);
//        yachtProp = "add";
//        System.out.println("add");
//    }
//
//    @FXML
//    void onCheckModifYacht(ActionEvent event) {
//        yachtModProp.setVisible(true);
//        propYachtText.setVisible(true);
//        yachtsRemoveCheck.setSelected(false);
//        yachtAddCheck.setSelected(false);
//        yachtProp = "modif";
//        System.out.println("modi");
//    }
//
//    @FXML
//    void onCheckRemoveYacht(ActionEvent event) {
//        yachtModProp.setVisible(false);
//        propYachtText.setVisible(false);
//        yachtsModifCheck.setSelected(false);
//        yachtAddCheck.setSelected(false);
//        yachtProp = "remove";
//        System.out.println("remove");
//    }
    @FXML
    void addYacht(ActionEvent event) {
        if ("search".equals(yachtProp)) {
            String[] data = {"0", idBox.getText(), nameBox.getText(), typeBox.getText(), lengthBox.getText(), pplBox.getText(), engBox.getText(), sailBox.getText()};

            updateList(Main.getFac().searchYachts(data));

            return;

        }

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
        switch (yachtProp) {
            case "add":
                Main.getFac().addYacht(data);
                break;
            case "modify":
                Main.getFac().modifyYacht(yachtModProp.getValue(), data);
                break;
            case "remove":
                Main.getFac().deleteYacht(Integer.parseInt(data[1]));
                break;

        }

        updateList(Main.getFac().getYachtsData());

        System.out.println(Main.getFac().getYachts());

    }

    @FXML
    void manageClient(ActionEvent event) {
        
         if ("search".equals(clientProp)) {
        String[] data = {"0", idBoxClient.getText(), nameBoxClient.getText(), surnameBoxClient.getText(), phoneBox.getText()};

            updateList(Main.getFac().searchClients(data));

            return;

        }


        try {
            Integer.parseInt(idBoxClient.getText());

        } catch (IllegalArgumentException e) {
            new Alert(Alert.AlertType.ERROR, "Wrong data").show();
            return;
        }
        System.out.println(Main.getFac().getClients());
        String[] data = {"1", idBoxClient.getText(), nameBoxClient.getText(), surnameBoxClient.getText(), phoneBox.getText()};
        System.out.println(Arrays.toString(data));
        switch (clientProp) {
            case "add":
                Main.getFac().addClient(data);
                break;
            case "modify":
                Main.getFac().modifyClient(clientModProp.getValue(), data);
                break;
            case "remove":
                Main.getFac().deleteClient(Integer.parseInt(data[1]));
                break;
        }
        updateList(Main.getFac().getClientsData());

        System.out.println(Main.getFac().getClients());

    }

    @FXML
    void manageReservation(ActionEvent event) {
        updateList(Main.getFac().getReservationsData());

    }

}
