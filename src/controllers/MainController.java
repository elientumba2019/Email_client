package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{



    //columns
    @FXML
    public TableColumn subjectColumn;
    @FXML
    public TableColumn sendColumn;
    @FXML
    public TableColumn sizeColumn;

    //layout table view
    public TableView emailTableView;

    



    
    /**
     * where averything will be set up before being used
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
}
