package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private ListView<String> listItems;

    private ObservableList<String> items = FXCollections.observableArrayList();

    protected int showItems(String[] data, ActionEvent event) {

        Optional<ButtonType> result = new Alert(Alert.AlertType.CONFIRMATION, "Search or show all?", new ButtonType("SEARCH"), new ButtonType("ALL"), ButtonType.CANCEL).showAndWait();
        int what = -1;
        if (result.isPresent()) {
            if (result.get() == ButtonType.CANCEL) {
                return 0;
            } else if (result.get().getText().equals("SEARCH")) {
// Szukanie dodać

                what = 1;

            } else if (result.get().getText().equals("ALL")) {

                updateList(data);

                what = 2;

            }

        }
        if (((Node) (event.getSource())).getScene().getWindow().getHeight() < 700) {
            ((Node) (event.getSource())).getScene().getWindow().setHeight(700);
            ((Node) (event.getSource())).getScene().getWindow().setY(((Node) (event.getSource())).getScene().getWindow().getY() - 100);

        }
        return what;
    }

    protected void updateList(String[] data) {
        items.clear();
        items.addAll(data);

        listItems.setItems(items);

        System.out.println(listItems.getItems());

    }

    protected void newScene(ActionEvent event, String fxmlName, int width, int height, boolean hide) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlName)), width, height);
            Stage stage = new Stage();

            stage.setTitle("MAZUROINATOR");
            stage.setScene(scene);

            stage.show();
            if (hide) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

}
