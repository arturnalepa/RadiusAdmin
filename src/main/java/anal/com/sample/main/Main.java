package anal.com.sample.main;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


@Configuration
@ComponentScan("anal.com.sample.*")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan
@SpringBootApplication

public class Main extends Application {

    public Parent root;

    @Override
    public void start(Stage stage) {


   //   new Progres().startIndicator();
            Wczytaj(stage);

                 }

    private void Wczytaj(Stage stage) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //   label.setText("aaa");
        try {
            root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //   Scene scene = new Scene(root, 300, 275);

        Scene scene = new Scene(root);
        stage.setTitle("Radmin");
    //   stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        stage.toBack();
            }
        });


    }

     public static void main(String[] args) {

        launch(args);
        SpringApplication.run(Main.class, args);


    }

    public Parent getContent() {
        return root;
    }


    public static void czytaj() throws IOException {
        ObservableList<CsvRead> dataList = FXCollections.observableArrayList();
        String CsvFile = "c:/Users/221072anal/IdeaProjects/RadiusAdmin/src/main/java/anal/com/sample/IPAD.csv";
        String FieldDelimiter = ";";

        BufferedReader br;


        br = new BufferedReader(new InputStreamReader(new FileInputStream(CsvFile), "US-ASCII"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(FieldDelimiter, -1);
            CsvRead record = new CsvRead(fields[0], fields[1], fields[2], fields[3]);
            System.out.print(record.getComputer());
            System.out.print(" " + record.getDescription());
            System.out.print(" " + record.getIP());
            System.out.println(" " + record.getMAC());
            dataList.add(record);
        }
    }
}
