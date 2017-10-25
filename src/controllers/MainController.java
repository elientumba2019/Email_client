package controllers;

import beans.EmailBean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    public WebView webView;

    //columns
    @FXML
    private TableColumn<EmailBean , String> subjectColumn;
    @FXML
    private TableColumn<EmailBean , String> sendColumn;
    @FXML
    private TableColumn<EmailBean , String> sizeColumn;

    //layout table view
    public TableView<EmailBean> emailTableView;




    /**
     * where averything will be set up before being used
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValues();
        webView.getEngine().load("http:www.bing.com");
    }




    /**
     * sets cell values properties for the table
     */
    private void setCellValues() {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<EmailBean , String>("subject"));
        sendColumn.setCellValueFactory(new PropertyValueFactory<EmailBean , String>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<EmailBean , String>("size"));
    }
}
