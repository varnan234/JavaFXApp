package com.varnan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class for registration and login.
 * 
 * @author Varnan Goenka
 * date 07/06/2024
 */
public class MainApp extends Application {

    /**
     * Starts the JavaFX application.
     * 
     * @param primaryStage the primary stage for this application
     * @throws Exception if an error occurs during loading the FXML file
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
        Scene scene = new Scene(root, 400, 300); // Set a larger window size
        primaryStage.setTitle("Registration Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Main method to launch the application.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
