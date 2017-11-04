import beans.Constants;
import javafx.application.Application;
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
        ViewFactory factory = ViewFactory.defaultFactory;
        Scene scene = factory.getScene(Constants.MAIN_LAYOUT);


        //setting the layout on screen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Email client");
        primaryStage.show();

    }
}
