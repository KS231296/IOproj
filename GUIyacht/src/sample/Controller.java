package sample;

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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

   

    @FXML
    private ListView<String> listItems;

    private ObservableList<String> items = FXCollections.observableArrayList();

   

    protected void showItems(String[] data, ActionEvent event) {
        items.clear();
        items.addAll(data);

        listItems.setItems(items);
        if (((Node) (event.getSource())).getScene().getWindow().getHeight() < 700) {
            ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
            ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

        }
        System.out.println(listItems.getItems());
    }

    protected void newScene(ActionEvent event, String fxmlName, int width, int height) {
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

}
