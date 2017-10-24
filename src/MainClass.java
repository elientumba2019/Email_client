import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {


    public static void main(String[] args){
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        //loading the main layout
        Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
        Scene scene = new Scene(root);

        //loading the style sheet
        String style = getClass().getResource("styles/style.css").toExternalForm();
        scene.getStylesheets().add(style);

        //setting the layout on screen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Email client");
        primaryStage.show();

    }
}
