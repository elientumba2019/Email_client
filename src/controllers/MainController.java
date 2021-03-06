package controllers;

import beans.Constants;
import beans.EmailBean;
import beans.Singleton;
import beans.table.BoldableRowFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import beans.SampleData;
import views.ViewFactory;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainController extends AbstractController implements Initializable{




    //menu item
    private MenuItem showDetails = new MenuItem("Show details");

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

    //singleton Instance
    private Singleton singleton;




    /**
     * constructor inherited from superclass
     * @param modelAccess
     */
    public MainController(ModelAccess modelAccess) {
        super(modelAccess);
    }




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
        setContextMenu();
        //getting singleton instance
        singleton = Singleton.getInstance();
    }




    /**
     * displays an email content dynamically
     * whenever a columns in the email list
     * is clicked on
     */
    private void handleTableColumnsClick(){
        emailTableView.setOnMouseClicked(L -> {
            EmailBean bean = emailTableView.getSelectionModel().getSelectedItem();
            if(bean != null){
                webView.getEngine().loadContent(bean.getContent());
                //passing the message to the model accesss
                super.getModelAccess().setSelectedMessage(bean);
            }
        });

    }




    /**
     * adds a context menu to the table view
     * context menu : menu that appears
     * when we click right
     */
    private void setContextMenu(){
        //adding the context menu
        emailTableView.setContextMenu(new ContextMenu(showDetails));
        showDetails.setOnAction(L -> {
            LoadDetailView();
        });
    }



    /**
     * loads the detail email view on Screen
     */
    private void LoadDetailView() {

        ViewFactory factory = ViewFactory.defaultFactory;
        Stage stage = new Stage();



            Scene scene = factory.getScene(Constants.DETAIL_LAYOUT);
            stage.setScene(scene);
            stage.show();

    }





    /**
     * initializes the tree
     * by setting tree items
     * to create a hierarchical structure
     */
    private void initializeTree() {

        //view factory instance
        ViewFactory factory = new ViewFactory();
        setRoot(factory);
        addTreeElement(factory);
        //click event method
        handleClick(emailFoldersTreeView);

    }





    /**
     * adds a few element to the tree view
     * @param factory
     */
    private void addTreeElement(ViewFactory factory) {
        //setting element po the tree elements
        TreeItem<String> inbox = new TreeItem<>("Inbox" , factory.resolveIcon("Inbox"));
        TreeItem<String> sent = new TreeItem<>("Sent" , factory.resolveIcon("Sent1"));
        TreeItem<String> s1 = new TreeItem<>("Subitem1" , factory.resolveIcon("Subitem"));
        TreeItem<String> s2 = new TreeItem<>("Subitem2" , factory.resolveIcon("Subitem"));
        sent.getChildren().addAll(s1 , s2);

        TreeItem<String> spam = new TreeItem<>("Spam" , factory.resolveIcon("Spam"));
        TreeItem<String> trash = new TreeItem<>("Trash" , factory.resolveIcon("Spam"));

        //set the root element
        root.getChildren().addAll(inbox , sent , spam , trash);
        root.setExpanded(true);
    }




    /**
     * sets the roots element
     * of the tree view
     * @param factory
     */
    private void setRoot(ViewFactory factory) {
        //setting the root of the tree
        emailFoldersTreeView.setRoot(root);
        root.setValue("xxx@yahoo.com");
        root.setGraphic(factory.resolveIcon(root.getValue()));
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
        //setting the row factory
        emailTableView.setRowFactory(a -> new BoldableRowFactory<>());

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



    @FXML
    public void changeReadAction(){
       EmailBean message = getModelAccess().getSelectedMessage();
       if(message != null){
           boolean isRead = message.isRead();
           message.setRead(!isRead);
       }
    }

}