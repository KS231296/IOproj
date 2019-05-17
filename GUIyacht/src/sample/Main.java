package sample;

import factoryAndFacade.Facade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("MAZUROINATOR");
        primaryStage.setScene(new Scene(root, 350, 150));
        primaryStage.show();
    }
    private static Facade fac = new Facade();

    public static Facade getFac() {
        return fac;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
