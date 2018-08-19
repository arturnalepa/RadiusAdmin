package anal.com.sample.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Handler;

public class Progres implements Runnable {
    private volatile boolean execute;

 //private  Stage stage ;
    private Scene scene;
    private StackPane root;
    private Thread currentThread;
    ProgressIndicator PI = new ProgressIndicator();
    Stage stage = new Stage();

    private volatile boolean shutdown;
    public void run() {
         currentThread = Thread.currentThread();
        root = new StackPane();
        scene = new Scene(root,500,750);
        startIndicator(stage);


    }
    public void shutdown() {

            currentThread.interrupt();

    }


    public void startIndicator(Stage stage) {
       root.getChildren().add(PI);
       stage.setScene(scene);
       root.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0);" +
                        "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);" +
                        "-fx-background-insets: 50;"
        );
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
        stage.toFront();

    }

}
