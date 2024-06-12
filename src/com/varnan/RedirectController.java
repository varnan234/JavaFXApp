package com.varnan;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @author Varnan
 * date 10/06/2024
 * A controller class for handling redirection to a web page.
 */
public class RedirectController {

    @FXML
    private WebView webView;

    /**
     * Initializes the controller class.
     * Loads the specified web page in the WebView.
     */
    @FXML
    public void initialize() {
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://github.com/varnan234");
    }
}
