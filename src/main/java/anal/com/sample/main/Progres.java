package anal.com.sample.main;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Progres {

 //private  Stage stage ;
 private Scene scene;
    private StackPane root;
    Stage stage = new Stage();

    public Progres() {
     root = new StackPane();
     scene = new Scene(root,350,750);


    }

    public void startIndicator() {

        ProgressIndicator PI = new ProgressIndicator();

        root.getChildren().add(PI);

        stage.setScene(scene);
        root.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0);" +
                        "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);" +
                        "-fx-background-insets: 50;"
        );
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Progress Indicator Example");
        stage.show();

    }


    public void startBar(Stage stage) {
        ProgressBar progressBar = new ProgressBar();
        StackPane root = new StackPane();
        progressBar.prefWidthProperty().bind(root.widthProperty().subtract(80));
        root.getChildren().add(progressBar);

        stage.setScene(scene);
        root.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0);" +
                        "-fx-effect: dropshadow(gaussian, 0, 50, 0, 0, 0);" +
                        "-fx-background-insets: 50;"
        );
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Progress Indicator Example");
        stage.show();

    }


    public void Close(){
     stage.close();

    }
}
