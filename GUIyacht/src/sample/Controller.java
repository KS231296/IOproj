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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ScrollPane scroll;

    @FXML
    private Text txtTesty;

    @FXML
    private Button add;

    private ObservableList<String> yachts = FXCollections.observableArrayList();

    @FXML
    void addShow(ActionEvent event) {
        Facade facade = new Facade();
        String yacht1[] = {"1", "Speed Demon", "motor boat", "20", "3", "500", "0"};
        String yacht2[] = {"2", "Butterfly", "sailing vessel", "50", "10", "50", "3"};

         

        yachts = FXCollections.observableArrayList(facade.addYacht(yacht1), facade.addYacht(yacht2));

        listYachts.setItems(yachts);
        txtTesty.setText(listYachts.getItems().toString());

        scroll.setVisible(true);

        ((Node) (event.getSource())).getScene().getWindow().setHeight(600);

    }

    @FXML
    void login(ActionEvent event) {

        newScene(event, "ownerView.fxml", 600, 300);

    }

    private void newScene(ActionEvent event, String fxmlName, int width, int height) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlName)), width, height);
            Stage stage = new Stage();

            stage.setTitle("MAZUROINATOR");
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setScene(scene);

            stage.show();

            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

}
