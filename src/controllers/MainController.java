package controllers;

import beans.EmailBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    public WebView webView;

    //columns
    @FXML
    private TableColumn<EmailBean , String> subjectColumn;
    @FXML
    private TableColumn<EmailBean , String> sendColumn;
    @FXML
    private TableColumn<EmailBean , String> sizeColumn;

    //layout table view
    @FXML
    public TableView<EmailBean> emailTableView;



    final ObservableList<EmailBean> list = FXCollections.observableArrayList(
            new EmailBean("food" , "xxx@gmail.com" , 24),
            new EmailBean("money" , "xxx@hotmail.com" , 12),
            new EmailBean("deal" , "xxx@qq.com" , 34),
            new EmailBean("things" , "xxx@baby.cn" , 12)
    );





    /**
     * where averything will be set up before being used
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValues();
        webView.getEngine().load("http:www.bing.com");
        emailTableView.setItems(list);
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
