package anal.com.sample.main;




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.*;
import java.util.logging.Logger;


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

        try {
            czytaj();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
//         //   Scene scene = new Scene(root, 300, 275);
//            Scene scene = new Scene(root);
//            stage.setTitle("FXML Welcome");
//            stage.setScene(scene);
//            stage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

    }
    public static void main(String[] args) {
        launch(args);
        SpringApplication.run(Main.class,args);



    }
    public Parent getContent() {
        return root;
    }


    public static void czytaj() throws IOException {
      ObservableList<CsvRead> dataList       = FXCollections.observableArrayList();
        String CsvFile = "c:/Users/221072anal/IdeaProjects/RadiusAdmin/src/main/java/anal/com/sample/IPAD.csv";
        String FieldDelimiter = ";";

        BufferedReader br;


        br = new BufferedReader( new InputStreamReader(new FileInputStream(CsvFile), "UTF-8"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(FieldDelimiter, -1);
            CsvRead record = new CsvRead(fields[0], fields[1], fields[2], fields[3]);
            System.out.print(record.getComputer());
            System.out.print(" "+record.getDescription());
            System.out.print(" "+record.getIP());
            System.out.println(" "+record.getMAC());
            dataList.add(record);
        }
    }
}
