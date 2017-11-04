package views;


import beans.Constants;
import controllers.AbstractController;
import controllers.EmailDetailController;
import controllers.MainController;
import controllers.ModelAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;

/**
 * this class job will bw to take care of everything related to the
 * scenes. things such as getting scenes , returning images. etc
 */
public class ViewFactory {


    public static ViewFactory defaultFactory = new ViewFactory();
    private static boolean mainViewInitialized = false;


    private final String DEFAULT_CSS = "style.css";

    private ModelAccess modelAccess = new ModelAccess();
    private MainController mainController;
    private EmailDetailController emailDetailController;




    
    /**
     * returns the main scene to some client
     * in case the pane is not present with its
     * layout element , an empty pane is returned
     * @return
     */
    public Scene getScene(String layoutName) throws OperationNotSupportedException {



        if(layoutName.equals(Constants.DETAIL_LAYOUT)){
            if(!mainViewInitialized){
                mainController = new MainController(modelAccess);
                mainViewInitialized = true;
                return initializeScene(layoutName , mainController);
            }
            else{
                throw new OperationNotSupportedException("Main scene already initialized");
            }
        }

        else{
            mainController = new MainController(modelAccess);
            Scene scene = initializeScene(layoutName  , mainController);
            return scene;
        }
    }










    /**
     * helper method to help in defining which
     * image needs to be used in the tree for its
     * elements
     * @param itemTreeValue
     * @return
     */
    public Node resolveIcon(String itemTreeValue){

        String lower = itemTreeValue.toLowerCase();
        ImageView returnIcon;


        try{

            if(lower.contains("inbox")){
                returnIcon = getImage("../views/images/inbox.png");
            }
            else if(lower.contains("sent")){
                returnIcon = getImage("../views/images/sent2.png");
            }
            else if(lower.contains("spam")){
                returnIcon = getImage("../views/images/spam.png");
            }
            else if(lower.contains("@")){
                returnIcon = getImage("../views/images/email.png");
            }
            else{
                returnIcon = getImage("../views/images/folder.png");
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



    /**
     * method to initialize a view
     * @param fxmlPath
     * @param controller
     * @return
     */
    private Scene initializeScene(String fxmlPath ,
                                  AbstractController controller){


        FXMLLoader loader;
        Parent parent;
        Scene scene;

        try {

            loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(controller);
            parent = loader.load();

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
;

        scene = new Scene(parent);
        String style = getClass().getResource(DEFAULT_CSS).toExternalForm();
        scene.getStylesheets().add(style);

        return scene;
    }
}
