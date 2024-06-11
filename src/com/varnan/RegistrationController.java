package com.varnan;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class RegistrationController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField confirmPasswordField;
	@FXML
	private Label statusLabel;
	@FXML
	private void handleRegisterButtonAction(ActionEvent event) {
		String username = usernameField.getText();
		String password = passwordField.getText();
		String confirmPassword = confirmPasswordField.getText();
		if (password.equals(confirmPassword)) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
				writer.write(username + "," + password);
				writer.newLine();
				statusLabel.setText("Registration Successful. Redirecting to login...");
				statusLabel.setStyle("-fx-text-fill: green;");
				// Pause for 2 seconds before redirecting to login
				new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(this::loadLoginPage);
					} catch (InterruptedException e) {
						e.printStackTrace();					}
				}).start();
			} catch (IOException e) {
				e.printStackTrace();
				statusLabel.setText("An error occurred while saving the user data.");
				statusLabel.setStyle("-fx-text-fill: red;");
			}
		} else {
			statusLabel.setText("Passwords do not match. Please try again.");
			statusLabel.setStyle("-fx-text-fill: red;");
		}
	}
	private void loadLoginPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
			Parent loginRoot = loader.load();
			Stage stage = (Stage) usernameField.getScene().getWindow();
			stage.setScene(new Scene(loginRoot, 400, 300));
			stage.setTitle("Login Page");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			statusLabel.setText("Failed to load the login page.");
			statusLabel.setStyle("-fx-text-fill: red;");
		}
	}
}
