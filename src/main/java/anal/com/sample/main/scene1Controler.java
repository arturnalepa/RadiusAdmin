package anal.com.sample.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class scene1Controler implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    boolean passwd = false;

    boolean usser = false;
    @FXML
    private AnchorPane content;


    @FXML
    void Login(ActionEvent event) {




        Stage stage = (Stage) login.getScene().getWindow();


        // AnchorPane root = null;
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("scene2.fxml"));
            Scene scene = new Scene(root);
            //  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void checklogin(KeyEvent event) {
        System.out.println("wwww");
    }

    @FXML
    void checkpassword(KeyEvent event) {
        password.widthProperty().addListener((obs, old, niu) -> {
            System.out.println(obs + "---" + old + "--" + niu);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(System.getProperty("user.name"));
        // VisibleButton(null, login, false, "");
        login.setVisible(false);
        username.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {

                if ((observableValue.getValue().isEmpty() != true)) {
                    VisibleButton(observableValue, login, true, username);
                } else {
                    VisibleButton(observableValue, login, false, username);
                    usser = false;
                }
            }
        });
        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                if (observableValue.getValue().isEmpty() != true) {
                    VisibleButton(observableValue, login, true, password);
                } else {
                    VisibleButton(observableValue, login, false, password);
                    passwd = false;
                }
            }
        });
    }

    void VisibleButton(ObservableValue<? extends String> observableValue, Button but, Boolean visble, TextField type) {

        if ((observableValue == null) || (type == null)) {
            but.setVisible(false);

        }
        if (username.getText().isEmpty() != true) {
            usser = true;
        }
        if (type == password) {
            passwd = true;
        }
        if (type == username) {
            usser = true;
        }
        {
            if ((observableValue.getValue().isEmpty() != true) && (usser == true) && ((passwd == true))) {
                but.setVisible(true);
            } else {
                but.setVisible(false);
            }

        }
    }


}
