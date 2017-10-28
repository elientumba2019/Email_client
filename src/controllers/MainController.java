package controllers;

import beans.EmailBean;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import sampleData.SampleData;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    //instance of the sample data class
    private SampleData sampleData = new SampleData();

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







    /**
     * where averything will be set up before being used
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValues();
        initializeTree();
        handleTableColumnsClick();
    }




    /**
     * displays an email content
     * whenever a columns in the email list
     * is clicked on
     */
    private void handleTableColumnsClick(){
        emailTableView.setOnMouseClicked(L -> {
            EmailBean bean = emailTableView.getSelectionModel().getSelectedItem();
            if(bean != null){
                webView.getEngine().loadContent(bean.getContent());
            }
        });
    }





    /**
     * initializes the tree
     * by setting tree items
     * to create a hierarchical structure
     */
    private void initializeTree() {
        //setting the root of the tree
        emailFoldersTreeView.setRoot(root);
        root.setValue("xxx@yahoo.com");
        root.setGraphic(resolveIcon(root.getValue()));

        //setting element po the tree elements
        TreeItem<String> inbox = new TreeItem<>("Inbox" , resolveIcon("Inbox"));
        TreeItem<String> sent = new TreeItem<>("Sent" , resolveIcon("Sent1"));
        TreeItem<String> s1 = new TreeItem<>("Subitem1" , resolveIcon("Subitem"));
        TreeItem<String> s2 = new TreeItem<>("Subitem2" , resolveIcon("Subitem"));
        sent.getChildren().addAll(s1 , s2);

        TreeItem<String> spam = new TreeItem<>("Spam" , resolveIcon("Spam"));
        TreeItem<String> trash = new TreeItem<>("Trash" , resolveIcon("Spam"));

        //set the root element
        root.getChildren().addAll(inbox , sent , spam , trash);
        root.setExpanded(true);

        //click event method
        handleClick(emailFoldersTreeView);

    }




    /**
     * handles click event for folders on the email client
     * @param emailFolder
     */
    private void handleClick(TreeView<String> emailFolder){

        emailFolder.setOnMouseClicked(L -> {
            //getting the selected item on the tree
            TreeItem<String> item = emailFolder.getSelectionModel().getSelectedItem();
            //if the selected item is not null , then load the corresponding folder
            if(item != null){
                emailTableView.setItems(sampleData.emailFolder.get(item.getValue()));
            }
        });
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







    /**
     * helper method to help in defining which
     * image needs to be used in the tree for its
     * elements
     * @param itemTreeValue
     * @return
     */
    private Node resolveIcon(String itemTreeValue){

        String lower = itemTreeValue.toLowerCase();
        ImageView returnIcon;


        try{

            if(lower.contains("inbox")){
                returnIcon = getImage("../images/inbox.png");
            }
            else if(lower.contains("sent")){
                returnIcon = getImage("../images/sent2.png");
            }
            else if(lower.contains("spam")){
                returnIcon = getImage("../images/spam.png");
            }
            else if(lower.contains("@")){
                returnIcon = getImage("../images/email.png");
            }
            else{
                returnIcon = getImage("../images/folder.png");
            }


        }catch (NullPointerException e){
            System.out.println("Wrong image location");
            returnIcon = new ImageView();
        }

        returnIcon.setFitHeight(16);
        returnIcon.setFitWidth(16);

        return returnIcon;
    }






    /**
     * retrieves the image
     * @param path
     * @return
     */
    private ImageView getImage(String path){
        Image image = new Image(getClass().getResourceAsStream(path));
        return new ImageView(image);
    }
}