package com.mycompany.cinema;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MainApp extends Application {

    //Stage Components
    private static Stage primaryStage;
    Scene scene;
    Parent root;

    //Scene id's Date = 1 , Movie = 2, Movie-Time = 3, Ticket = 4, payment = 5
    public int sceneId = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Cinema Kiosk");
        initialLayout("/fxml/Scene.fxml");
    }

    public void initialLayout(String scenes) {

        try {
            root = FXMLLoader.load(getClass().getResource(scenes));
            scene = new Scene(root); // passing the root object to the constructor
            scene.getStylesheets().add("/styles/Styles.css"); //adding styles
            primaryStage.setScene(scene); // attach the object to the stage
            primaryStage.show(); // display the contents of the scene

        } catch (IOException ex) {
            // Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Movie buttons Scenes
    public void viewMovieScene() throws Exception {

        String sceneLayout = "/fxml/Movie.fxml";
        initialLayout(sceneLayout);

    }

    //Movie Times
    public void viewTimeScene() throws Exception {

        String sceneLayout = "/fxml/Time.fxml";
        initialLayout(sceneLayout);

    }

    //Ticket Selection
    public void viewTicketScene() throws Exception {

        String sceneLayout = "/fxml/Ticket.fxml";
        initialLayout(sceneLayout);

    }

    //customer payment selection
    public void viewPaymentScene() throws Exception {

        String sceneLayout = "/fxml/Payment.fxml";
        initialLayout(sceneLayout);

    }

    //Final Scene "thank you"
    public void viewThankyouScene() throws Exception {

        String sceneLayout = "/fxml/Thank.fxml";
        initialLayout(sceneLayout);

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

}
