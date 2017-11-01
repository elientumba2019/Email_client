package controllers;

import beans.Singleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailDetailController implements Initializable {


    @FXML
    public Label subjectLable;
    @FXML
    public Label senderLabel;
    @FXML
    public WebView emailRenderedWebView;

    //singleton
    private Singleton singleton;

    /**
     * takes care of everything that
     * must be done before having the scene
     * on screen
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        singleton = Singleton.getInstance();
    }
}
