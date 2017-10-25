package controllers;

import beans.EmailBean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{



    //columns
    @FXML
    public TableColumn<EmailBean , String> subjectColumn;
    @FXML
    public TableColumn<EmailBean , String> sendColumn;
    @FXML
    public TableColumn<EmailBean , String> sizeColumn;
    //layout table view
    public TableView<EmailBean> emailTableView;

    



    
    /**
     * where averything will be set up before being used
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
