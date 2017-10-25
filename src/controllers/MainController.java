package controllers;

import beans.EmailBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    //web view
    @FXML
    public WebView webView;

    //tree view
    public TreeView<String> emailFoldersTreeView;
    //tree item for the tree view element
    private TreeItem<String> root = new TreeItem<>();

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
        initializeTree();
    }


    /**
     * initializes the tree
     * by setting tree items
     * to create a hierarchical structure
     */
    private void initializeTree() {
        emailFoldersTreeView.setRoot(root);
        root.setValue("xxx@yahoo.com");

        TreeItem<String> inbox = new TreeItem<>("Inbox");

        TreeItem<String> sent = new TreeItem<>("Sent");
        TreeItem<String> s1 = new TreeItem<>("Subitem1");
        TreeItem<String> s2 = new TreeItem<>("Subitem2");
        sent.getChildren().addAll(s1 , s2);

        TreeItem<String> spam = new TreeItem<>("Spam");

        TreeItem<String> trash = new TreeItem<>("Trash");

        root.getChildren().addAll(inbox , sent , spam , trash);
        root.setExpanded(true);

    }



    /**
     * sets cell values properties for the table
     */
    private void setCellValues() {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<EmailBean , String>("subject"));
        sendColumn.setCellValueFactory(new PropertyValueFactory<EmailBean , String>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<EmailBean , String>("size"));




        //comparator to sort the size
        sizeColumn.setComparator(new Comparator<String>() {

            Integer int1 , int2;

            @Override
            public int compare(String o1, String o2) {

                int1 = EmailBean.formattedValues.get(o1);
                int2 = EmailBean.formattedValues.get(o2);
                return int1.compareTo(int2);
            }
        });
    }
}
