/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


import java.time.LocalDate;
import java.util.Arrays;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
     @FXML
    void addReservation(ActionEvent event) {     
        String id = txtClient.getText();
         System.out.println(id + "to to");
        String [] clientdata = {"0", id};
        String client = Main.getFac().searchClient(clientdata);
         System.out.println(client);
        String model = txtModel.getText();
        String [] yachtdata = {"0","123", model};
        String yacht = Main.getFac().searchYacht(yachtdata);
         System.out.println(Arrays.toString(yachtdata)+ "hueheuehe");
        String data1 = txtDateStart.getText();
        String data2 = txtDateEnd.getText();
        String [] datesOfReservation = {data1, data2};
         System.out.println(Arrays.toString(datesOfReservation) + "********");
        Main.getFac().addReservation(clientdata,yachtdata,datesOfReservation);
    
        
         
         //String[] data = {"1", idBoxClient.getText(), nameBoxClient.getText(), surnameBoxClient.getText(), phoneBox.getText()};
         
      

    }
    
    @FXML
    void showYachts(ActionEvent event) {

       showItems(Main.getFac().getYachtsData(), event);

    
    
}
    
    
    
    
    @FXML
    void showFree(ActionEvent event) {
        
      LocalDate data1 = LocalDate.parse(startdata.getText());
      LocalDate data2 = LocalDate.parse(enddata.getText());
      String model = modelY.getText();
      String yachtData [] = {"0",model};
      String yacht = Main.getFac().searchYacht(yachtData);
   
      
      
        

    }
    
 
}
