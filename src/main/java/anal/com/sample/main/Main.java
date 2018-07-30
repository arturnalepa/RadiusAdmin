package anal.com.sample.main;




import javafx.application.Application;
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
            root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            Scene scene = new Scene(root, 300, 275);
            stage.setTitle("FXML Welcome");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
        SpringApplication.run(Main.class,args);


    }
    public Parent getContent() {
        return root;
    }
}
