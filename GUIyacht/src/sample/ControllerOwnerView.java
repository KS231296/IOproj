/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.Arrays;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Kinu
 */
public class ControllerOwnerView extends Controller {
 

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
        Main.getFac().addYacht(data);
        System.out.println(Main.getFac().getYachts());

    }
  @FXML
    void addShow(ActionEvent event) {
        Optional<ButtonType> result = new Alert(Alert.AlertType.CONFIRMATION, "Search or show all?", new ButtonType("SEARCH"), new ButtonType("ALL"), ButtonType.CANCEL).showAndWait();

        if (result.isPresent()) {
            if (result.get() == ButtonType.CANCEL) {
                return;
            } else if (result.get().getText().equals("SEARCH")) {
                System.out.println("search");
            } else if (result.get().getText().equals("ALL")) {
                System.out.println("all");

                showItems(Main.getFac().getYachtsData(), event);
                
                 if (((Node) (event.getSource())).getScene().getWindow().getHeight() < 700) {
            ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
            ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

        }
            }

        }

    }

  
    
}
