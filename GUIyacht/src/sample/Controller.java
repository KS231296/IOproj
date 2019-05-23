package sample;

import factoryAndFacade.Facade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import owner.Yacht;

public class Controller {

    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ListView<String> listYachts;

  

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

    private ObservableList<String> yachts = FXCollections.observableArrayList();

    @FXML
    void addShow(ActionEvent event) {
    //    String yacht1[] = {"1", "1", "Speed Demon", "motor boat", "20", "3", "500", "0"};
      //  String yacht2[] = {"1", "2", "Butterfly", "sailing vessel", "50", "10", "50", "3"};

  //      yachts.addAll(Main.getFac().addYacht(yacht1), Main.getFac().addYacht(yacht2));

        listYachts.setItems(yachts);
//        txtTesty.setText(listYachts.getItems().toString());

        ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
        ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

    }

    @FXML
    void login(ActionEvent event) {
        System.out.println(txtLogin.getText() + txtPassword.getText());
        if (txtLogin.getText().equals("owner") && txtPassword.getText().equals("owner")) {
            newScene(event, "ownerView.fxml", 600, 320);
        }

    }

 @FXML
public void enter(KeyEvent e){

    if(e.getCode()==KeyCode.ENTER){
        btnLogin.fire();
    }
}

    private void newScene(ActionEvent event, String fxmlName, int width, int height) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlName)), width, height);
            Stage stage = new Stage();

            stage.setTitle("MAZUROINATOR");
            stage.setScene(scene);

            stage.show();

            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

    @FXML
    void showClients(ActionEvent event) {

    }

    @FXML
    void showReservations(ActionEvent event) {

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

        String[] data = {"1", idBox.getText(), nameBox.getText(), typeBox.getText(), lengthBox.getText(), pplBox.getText(), engBox.getText(), sailBox.getText()};
        System.out.println(Arrays.toString(data));
       Main.getFac().addYacht(data);
       

    }

}
