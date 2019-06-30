package quiz;

import javafx.concurrent.Worker;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    public WebView graph;
    public AnchorPane webPane;
    public ProgressBar statusBar;
    public Label statusLabel;

    WebEngine engine;

   private int length = 12;
   private int defaultLength = 600/length;

   //This is the first thing that happens after initialization
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Assign the GraphicsContext that we use to draw on the canvas

        //We first draw the coordinate system
        engine = graph.getEngine();
        Worker<Void> worker = engine.getLoadWorker();
        worker.stateProperty().addListener((v, oldValue, newValue) ->{
            statusLabel.setText("Loading state: " + newValue.toString());
            if (newValue == Worker.State.SUCCEEDED){
                statusLabel.setText("Finished");
            }
        });

        statusBar.progressProperty().bind(worker.progressProperty());

        engine.loadContent("<html></html>");
        drawGraph();
    }

    public void draw(){

    }

    public void drawGraph() {
        String height = Double.toString(webPane.getHeight() - 20);
        String width = Double.toString(webPane.getWidth() - 20);
        engine.loadContent("<html><body><script src=\"https://www.desmos.com/api/v1.3/calculator.js?apiKey=dcb31709b452b1cf9dc26972add0fda6\"></script><div id=\"calculator\" style=\"width: " + width + "px; height: " + height + "px;\"></div><script>\n" +
                "  var elt = document.getElementById('calculator');\n" +
                "  var calculator = Desmos.GraphingCalculator(elt,{expressions: false});\n" +
                "  calculator.setExpression({id:'graph1', latex:'y=x^2'});\n" +
                "</script></body></html>");
    }
}