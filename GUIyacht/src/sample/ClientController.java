/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import owner.Yacht;

/**
 *
 * @author dell
 */
public class ClientController extends Controller {
    
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

    @FXML   private RadioButton yachtsRemoveCheck;

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
    private TextField surnameBoxClient;

    @FXML
    private TextField phoneBox;

    @FXML
    private TextField idBoxClient;




    @FXML
    private TextField txtDateStart;

    @FXML
    private TextField txtDateEnd;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtClient;
    
    
    @FXML
    private TextField startdata;
    
    @FXML
    private TextField enddata;
    
    
     @FXML
    private TextField modelY;
   
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
    private Button ownbtn;
   
     @FXML
    private TextField txtID;
    
    
    @FXML
    void addClient(ActionEvent event) {     
     System.out.println(Main.getFac().getClients());
        String[] data = {"1", idBoxClient.getText(), nameBoxClient.getText(), surnameBoxClient.getText(), phoneBox.getText()};
        System.out.println(Arrays.toString(data));
        
        Main.getFac().addClient(data);
              
        updateList(Main.getFac().getClientsData());
        idBoxClient.clear();
        nameBoxClient.clear();
        surnameBoxClient.clear();
        phoneBox.clear();
        System.out.println(Main.getFac().getClients());

    }
    
    @FXML
    void ownerpanelclick(ActionEvent event) {
    newScene(event, "start.fxml", 300, 150, true);
    }
    
    
    int numer;
     @FXML
    void addReservation(ActionEvent event) {     
        numer++;
        String id = txtClient.getText();
         System.out.println(id + "to to");
        String [] clientdata = {"0", id};
        String client = Main.getFac().searchClient(clientdata);
         System.out.println(client);
        String model = txtModel.getText();
        String ID = txtID.getText();
        String [] yachtdata = {"0", ID, model};
         System.out.println(Arrays.toString(yachtdata)+ "hueheuehe");
        String data1 = txtDateStart.getText();
        String data2 = txtDateEnd.getText();
        String numerStr = String.valueOf(numer);
        String [] datesOfReservation = {"1", numerStr, data1, data2};
        System.out.println(Arrays.toString(datesOfReservation) + "********");
        Main.getFac().addReservation(clientdata,yachtdata,datesOfReservation);
         System.out.println(Main.getFac().addReservation(clientdata,yachtdata,datesOfReservation));
//         String [] tab  = Main.getFac().getReservationsData();
//         String s = "";
//         StringBuilder sB = new StringBuilder(s);
//         for (int i =0; i <tab.length;i++) {
//             	sB.append(tab[i]);
//         }
//         s = sB.toString();
      showItems(Main.getFac().getClientReservationsData(id),event);
        String [] tab = (Main.getFac().getReservationsData());
         for (String tab1 : tab) {
             System.out.println(tab1);
         }
//         
         //String[] data = {"1", idBoxClient.getText(), nameBoxClient.getText(), surnameBoxClient.getText(), phoneBox.getText()};
         
      

    }
    
    @FXML
    void showYachts(ActionEvent event) {

       showItems(Main.getFac().getYachtsData(), event);
    
}
    
  
    @FXML
    void showFree(ActionEvent event) {
        
              String[] yachtData  = {"0", null, nameBox.getText(), typeBox.getText(), lengthBox.getText(), pplBox.getText(), engBox.getText(), sailBox.getText()};

 try {
                    Double.parseDouble(yachtData[4]); // length
                    Integer.parseInt(yachtData[5]); // ppl
                    Double.parseDouble(yachtData[6]); //eng
                    Integer.parseInt(yachtData[7]); // sail

                } catch (IllegalArgumentException e) {
                    new Alert(Alert.AlertType.ERROR, "Wrong data").show();
                    return;
                }

      String[] yacht = Main.getFac().searchYachts(yachtData);
        
      showItems(yacht, event);
    }
    
    
    
 
}
