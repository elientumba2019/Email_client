package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailDetailController implements Initializable {


    @FXML
    public Label subjectLable;
    @FXML
    public Label senderLabel;

    /**
     * takes care of everything that
     * must be done before having the scene
     * on screen
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
