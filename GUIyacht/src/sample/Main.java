package sample;

import factoryAndFacade.Facade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Facade fac = new Facade();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        primaryStage.setTitle("MAZUROINATOR");
        primaryStage.setScene(new Scene(root, 753, 691));
        primaryStage.show();
    }

    public static Facade getFac() {
        return fac;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
