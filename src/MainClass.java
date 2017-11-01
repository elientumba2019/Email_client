import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.ViewFactory;

public class MainClass extends Application {


    public static void main(String[] args){
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        //view factory instance
        ViewFactory factory = new ViewFactory();
        Scene scene = factory.getMainScene("main.fxml");
        

        //setting the layout on screen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Email client");
        primaryStage.show();

    }
}
