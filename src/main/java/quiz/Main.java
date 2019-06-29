package quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;



/**
 *<h1>Math Quiz</h1>
 * Math Quiz is a simple application that shows a mathematical graph,
 * where the user than has to specify all function properties.
 *
 * @author Jani Bangiev
 * @version 1.0
 * @since 27.6.2019
 *
 */

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Define where we get the fxml resources from (fxml describes the look of the application)
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));

        //Basic setup for the application
        primaryStage.setTitle("Math Quiz");
        primaryStage.setScene(new Scene(root,1024 ,600 ));

        //Setting the application to be fullScreen
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);

        //Setting the application bounds here
        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(600);

        //Displaying the application
        primaryStage.show();
    }
}
