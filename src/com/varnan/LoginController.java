package com.varnan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Varnan
 * date 10/06/2024
 * A controller class for handling login functionality.
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    /**
     * Handles the login button action.
     * @param event The action event triggered by the login button.
     */
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                loadRedirectPage();
            } else {
                statusLabel.setText("Incorrect username or password.");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("An error occurred while reading the user data.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    /**
     * Loads the redirect page upon successful login.
     */
    private void loadRedirectPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RedirectPage.fxml"));
            Parent redirectRoot = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(redirectRoot, 800, 600));
            stage.setTitle("Redirect Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Failed to load the redirect page.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
