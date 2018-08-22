package anal.com.sample.main;

import anal.com.sample.model.Nas;
import anal.com.sample.repository.service.INasService;
import anal.com.sample.service.service.NasService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddNas implements Initializable {
    @FXML
    private TextField ipoctet1;

    @FXML
    private TextField ipoctet2;

    @FXML
    private TextField ipoctet3;

    @FXML
    private TextField ipoctet4;

    @FXML
    private TextField nasiphost;

    @FXML
    private TextField nassecret;

    @FXML
    private TextField nasshortname;

    @FXML
    private TextField nasport;

    @FXML
    private TextField nascomunity;

    @FXML
    private TextArea nasdescription;

    @FXML
    private Button addnas;
    @FXML
    private TableView<Nas> nastable;

    @FXML
    private TableColumn<Nas, String> tabnas_c1;

    @FXML
    private TableColumn<Nas, String> tabnas_c2;

    @FXML
    private TableColumn<Nas, String> tabnas_c3;

    @FXML
    private TableColumn<Nas, Integer> tabnas_c4;

    @FXML
    private TableColumn<Nas, String> tabnas_c5;

    @FXML
    private TableColumn<Nas, String> tabnas_c6;

    @FXML
    private TableColumn<Nas, String> tabnas_c7;

    @FXML
    private Label lblilosc;


    private ObservableList<Nas> nasTableData = FXCollections.observableArrayList();
    private INasService serviceNas;
    Nas nas = new Nas();
    Nas tablenas = new Nas();

    @FXML
    void AddNas(ActionEvent event) {
        int port;
        Nas nas = new Nas();
        String IP = ipoctet1.getText() + "." + ipoctet2.getText() + "." + ipoctet3.getText() + "." + ipoctet4.getText();
        IPValidator ipvalid = new IPValidator();
        if (nasport.getText().isEmpty() != true) {
            port = (Integer.parseInt(nasport.getText()));
        } else {
            port = nas.getPorts();
        }

        nas.setCommunity(nascomunity.getText());
        nas.setDescription(nasdescription.getText());
        nas.setNasname(IP);
        nas.setPorts(port);
        nas.setSecret(nassecret.getText());
        nas.setShortname(nasshortname.getText());
        nas.setType(null);

        if (ipvalid.validateIP(IP) != false) {
            if (nassecret.getText().isEmpty() != true) {
                serviceNas.saveOrUpdate(nas);
                initializeColumns();
                ClearjTextField();
            } else {
                JOptionPane.showMessageDialog(null, "Pole secret nie mo�e by� puste ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sprawd� poprawno�� adresu IP !! ", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void ClearjTextField() {
        nascomunity.clear();
        nasdescription.clear();
        nassecret.clear();
        nasshortname.clear();
        ipoctet1.clear();
        ipoctet2.clear();
        ipoctet3.clear();
        ipoctet4.clear();
    }

    public ObservableList<Nas> getNasData() {
        return nasTableData;
    }

    @FXML
    void MAx3char() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  serviceNas = new NasService();
        serviceNas = new NasService();
        nasport.setText("1812");
        initualizeIPValidator();
        initializeColumns();


    }

    private void initualizeIPValidator() {
        ipoctet1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                IPValidator ipvalid = new IPValidator();
                if (ipvalid.validateIPOctets(observableValue.getValue()) != false) {
                    ipoctet1.setStyle("-fx-text-fill: black;");
                } else {
                    ipoctet1.setStyle("-fx-text-fill: red;");
                }
            }
        });
        ipoctet2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                IPValidator ipvalid = new IPValidator();
                if (ipvalid.validateIPOctets(observableValue.getValue()) != false) {
                    ipoctet2.setStyle("-fx-text-fill: black;");
                } else {
                    ipoctet2.setStyle("-fx-text-fill: red;");
                }
            }
        });
        ipoctet3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                IPValidator ipvalid = new IPValidator();
                if (ipvalid.validateIPOctets(observableValue.getValue()) != false) {
                    ipoctet3.setStyle("-fx-text-fill: black;");
                } else {
                    ipoctet3.setStyle("-fx-text-fill: red;");
                }
            }
        });
        ipoctet4.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                IPValidator ipvalid = new IPValidator();
                if (ipvalid.validateIPOctets(observableValue.getValue()) != false) {
                    ipoctet4.setStyle("-fx-text-fill: black;");
                } else {
                    ipoctet4.setStyle("-fx-text-fill: red;");
                }
            }
        });

        registerListener(ipoctet1, ipoctet2);
        registerListener(ipoctet2, ipoctet3);
        registerListener(ipoctet3, ipoctet4);
        registerListener(ipoctet4, ipoctet1);
    }

    public void registerListener(TextField tf1, TextField tf2) {
        tf1.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.matches("\\d*")) {
                tf1.setText(newText.replaceAll("[^\\d]", ""));
            } else {
                if (oldText.length() < 3 && newText.length() >= 3) {
                    tf2.requestFocus();
                }
            }
        });
    }

    private void initializeColumns() {

        TableColumn<Nas, String> colNASIP = new TableColumn<Nas, String>("NAS IP/Host");
        TableColumn<Nas, String> colNASShortname = new TableColumn<Nas, String>("NAS Shortname");
        TableColumn<Nas, String> colNASType = new TableColumn<Nas, String>("NAS Type");
        TableColumn<Nas, Integer> colNASPorts = new TableColumn<Nas, Integer>("NAS Ports");
        TableColumn<Nas, String> colNASSecret = new TableColumn<Nas, String>("NAS Secret");
        TableColumn<Nas, String> colNASCommunity = new TableColumn<Nas, String>("NAS Community");
        TableColumn<Nas, String> colNASDescription = new TableColumn<Nas, String>("NAS Description ");

        nastable.getColumns().setAll(colNASIP, colNASShortname, colNASType, colNASPorts, colNASSecret, colNASCommunity, colNASDescription);

        colNASIP.setCellValueFactory(new PropertyValueFactory<Nas, String>("nasname"));
        colNASShortname.setCellValueFactory(new PropertyValueFactory<Nas, String>("shortname"));
        colNASType.setCellValueFactory(new PropertyValueFactory<Nas, String>("type"));
        colNASPorts.setCellValueFactory(new PropertyValueFactory<Nas, Integer>("ports"));
        colNASSecret.setCellValueFactory(new PropertyValueFactory<Nas, String>("secret"));
        colNASCommunity.setCellValueFactory(new PropertyValueFactory<Nas, String>("community"));
        colNASDescription.setCellValueFactory(new PropertyValueFactory<Nas, String>("description"));

        colNASIP.setCellFactory(TextFieldTableCell.forTableColumn());
        colNASShortname.setCellFactory(TextFieldTableCell.forTableColumn());
        colNASType.setCellFactory(TextFieldTableCell.forTableColumn());
        colNASPorts.setCellFactory(TextFieldTableCell.<Nas, Integer>forTableColumn(new IntegerStringConverter()));
        colNASSecret.setCellFactory(TextFieldTableCell.forTableColumn());
        colNASDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        colNASCommunity.setCellFactory(TextFieldTableCell.forTableColumn());


        colNASIP.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, String>>() {
            public void handle(TableColumn.CellEditEvent<Nas, String> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setNasname(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }
        });

        colNASShortname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, String>>() {
            public void handle(TableColumn.CellEditEvent<Nas, String> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setShortname(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }
        });
        colNASType.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, String>>() {
            public void handle(TableColumn.CellEditEvent<Nas, String> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setType(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }
        });
        colNASPorts.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, Integer>>() {
            public void handle(TableColumn.CellEditEvent<Nas, Integer> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setPorts(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }
        });
        colNASSecret.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, String>>() {
            public void handle(TableColumn.CellEditEvent<Nas, String> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setSecret(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }
        });
        colNASDescription.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, String>>() {
            public void handle(TableColumn.CellEditEvent<Nas, String> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setDescription(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }
        });
        colNASCommunity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Nas, String>>() {
            public void handle(TableColumn.CellEditEvent<Nas, String> event) {
                Nas nasselecy = new Nas();
                nasselecy = serviceNas.getNasByNasname(nastable.getSelectionModel().getSelectedItem().getNasname());
                nasselecy.setCommunity(event.getNewValue());
                serviceNas.saveOrUpdate(nasselecy);
            }

        });


        List<Nas> nasList = serviceNas.getAllNas();
        lblilosc.setText(String.valueOf(nasList.size()));
        nasTableData.setAll(nasList);
        nastable.setItems(getNasData());
        nastable.setEditable(true);


    }

}

