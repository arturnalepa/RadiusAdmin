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

public class Progres extends Application {

 //private  Stage stage ;
 private Scene scene;
    private StackPane root;

    ProgressIndicator PI = new ProgressIndicator();
    public Progres() {

    }
    @Override
    public void start(Stage stage){
        startIndicator(stage);
    }
    public void startIndicator(Stage stage) {

                root = new StackPane();
                scene = new Scene(root,500,750);


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
     //   stage.setTitle("Progress Indicator Example");
///stage.setFullScreen(true);
        stage.show();
        stage.toFront();

    }




    public void Close(Stage stage){
      //  System.exit(0);
      //  root.setVisible(false);
       // root.getScene().getWindow().hide();
      // this.root.getScene().getWindow().clo
stage.close();
            //root.getChildren().clear();
//stage.hide();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
