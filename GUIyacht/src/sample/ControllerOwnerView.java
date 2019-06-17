/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.Arrays;

import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

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
    private RadioButton cancResCheck;

    @FXML
    private ToggleGroup reservationsGroup;

    @FXML
    private RadioButton addResCheck;

    @FXML
    private RadioButton searchResCheck;

    @FXML
    private TextField resIdBox;

    @FXML
    private TextField modelResBox;

    @FXML
    private Button ClientPanelbtn;

    @FXML
    public void initialize() {
        yachtModProp.setVisible(false);
        propYachtText.setVisible(false);
        yachtProp = "add";

        clientModProp.setVisible(false);
        propClientText.setVisible(false);
        clientProp = "add";

        reservationProp = "add";

        yachtsGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton chk = (RadioButton) newValue;
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

        reservationsGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton chk = (RadioButton) newValue;
            reservationProp = chk.getText().toLowerCase();
        });

        System.out.println("Init");
    }

    @FXML
    void showYachts(ActionEvent event) {
        showItems(Main.getFac().getYachtsData(), event);

    }

    @FXML
    void showClients(ActionEvent event) {

        showItems(Main.getFac().getClientsData(), event);

    }

    @FXML
    void showReservations(ActionEvent event) {
        showItems(Main.getFac().getReservationsData(), event);
    }

    @FXML
    void addYacht(ActionEvent event) {
        System.out.println("yactProp");
       

        System.out.println(Main.getFac().getYachts());
        String[] data = {"1", idBox.getText(), nameBox.getText(), typeBox.getText(), lengthBox.getText(), pplBox.getText(), engBox.getText(), sailBox.getText()};
        System.out.println(Arrays.toString(data));
        switch (yachtProp) {
            case "search":
            data[0] = "0";
            System.out.println("data: " + Arrays.toString(data));
            updateList(Main.getFac().searchYachts(data));

break;
        
            
            case "add":
                try {
                    Double.parseDouble(data[4]); // length
                    Integer.parseInt(data[5]); // ppl
                    Double.parseDouble(data[6]); //eng
                    Integer.parseInt(data[7]); // sail

                } catch (IllegalArgumentException e) {
                    new Alert(Alert.AlertType.ERROR, "Wrong data").show();
                    return;
                }

                if (Main.getFac().addYacht(data) == null) {
                    new Alert(Alert.AlertType.ERROR, "Yacht not added. Check ID").show();
                    return;
                }

                break;
            case "modify":
                String mod = yachtModProp.getValue();
                String[] dataMod = new String[2];
                Boolean changed = false;
                switch (mod) {
                    case "name":
                        dataMod[0] = data[1];
                        dataMod[1] = data[2];

                        break;
                    case "enginePower":
                        try {

                            Double.parseDouble(data[6]); //eng

                        } catch (IllegalArgumentException e) {
                            new Alert(Alert.AlertType.ERROR, "engine not a number").show();
                            return;
                        }
                        dataMod[0] = data[1];
                        dataMod[1] = data[6];
                        break;
                    case "sailsNumber":
                        try {

                            Integer.parseInt(data[7]); // sail

                        } catch (IllegalArgumentException e) {
                            new Alert(Alert.AlertType.ERROR, "Sails not an integer").show();
                            return;
                        }

                        dataMod[0] = data[1];
                        dataMod[1] = data[7];
                        break;

                }
                if (!Main.getFac().modifyYacht(mod, dataMod)) {
                    new Alert(Alert.AlertType.ERROR, "Modyfication failed").show();
                    return;
                }

                break;
            case "remove":
                Main.getFac().deleteYacht(data[1]);
                break;

        }

        updateList(Main.getFac().getYachtsData());
        idBox.clear();
        nameBox.clear();
        typeBox.clear();
        lengthBox.clear();
        pplBox.clear();
        engBox.clear();
        sailBox.clear();

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
                Main.getFac().deleteClient(data[1]);
                break;
        }
        updateList(Main.getFac().getClientsData());
        idBoxClient.clear();
        nameBoxClient.clear();
        surnameBoxClient.clear();
        phoneBox.clear();
        System.out.println(Main.getFac().getClients());

    }

    @FXML
    void clientPanel(ActionEvent event) {
        newScene(event, "client.fxml", 600, 650, true);
    }
}
//    @FXML
//    void manageReservation(ActionEvent event) {
//        
//        
//         
////         if ("search".equals(reservationProp)) {
////            String resId = resIdBox.getText();
////            updateList(Main.getFac().searchReservation(resId));
////            return;
////        }
//         
//        try {
//            Integer.parseInt(resIdBox.getText());
//
//        } catch (IllegalArgumentException e) {
//            new Alert(Alert.AlertType.ERROR, "Wrong data").show();
//            return;
//        }
//        
//        String[] data = {"1",resIdBox.getText()};
//        String[] dateData = {txtDateStart.getText(),txtDateEnd.getText()};
//        String yachtID = modelResBox.getText();
//        String clientID = txtClient.getText();
//        switch (reservationProp) {
//            case "add":
//                System.out.println(yachtID);
//                Main.getFac().addReservation(data,yachtID,clientID,dateData);
//                break;
//                
//            case "search":
//                Main.getFac().searchReservation(resIdBox.getText());
//                break;
//            case "cancel":
//                Main.getFac().cancelReservation(resIdBox.getText(), txtClient.getText());
//                break;
//            
//        }
//        updateList(Main.getFac().getReservationsData());
//       resIdBox.clear();
//       txtDateStart.getText();
//       txtDateEnd.clear();
//       modelResBox.clear();
//        System.out.println(Main.getFac().getReservations());
//
//
//    }
//
//}
