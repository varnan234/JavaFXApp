package com.varnan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Varnan Goenka
 * date 10/06/2024
 * The main application class for the JavaFX registration and login application.
 */
public class MainApp extends Application {

    /**
     * The main entry point for the JavaFX application.
     * @param primaryStage The primary stage for this application.
     * @throws Exception if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrationPage.fxml"));
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Registration Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method for launching the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
