package anal.com.sample.main;

import anal.com.sample.model.*;
import anal.com.sample.repository.service.*;
import anal.com.sample.service.service.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.DefaultStringConverter;
import org.springframework.stereotype.Component;
import javafx.util.Callback;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
public class scene2Controler {

    @FXML
    public TextField MacAddress;
    @FXML
    public TextField MacPassword;
    @FXML
    public ComboBox VlanGroup;
    @FXML
    public CheckBox checkMacPass;
    @FXML
    public Label LMaCAddress;
    @FXML
    public Button AddClient;
    @FXML
    private Button addNas;
    @FXML
    TableView<UserTableData> personTable;
    @FXML
    private TableColumn<UserTableData, String> colname;
    @FXML
    private TableColumn<UserTableData, String> colmacaddress;
    @FXML
    private TableColumn<UserTableData, String> colmacpassword;
    @FXML
    private TableColumn<UserTableData, String> colvlan;
    @FXML
    private TableColumn<UserTableData, String> colnotes;

    @FXML
    private TableColumn<UserTableData, String> colipaddress;
    @FXML
    TableView<Radacct> TableRadacct;
    @FXML
    private TableColumn<Radacct, String> framedipaddress;

    @FXML
    private TableColumn<Radacct, String> nasip;

    @FXML
    private TableColumn<Radacct, String> nasport;

    @FXML
    private TableColumn<Radacct, String> acctstarttime;

    @FXML
    private TableColumn<Radacct, String> acctstoptime;
    @FXML
    private TextField find;
    @FXML
    private Label firstname;

    @FXML
    private Label creationdate;

    @FXML
    private Label notes;
    @FXML
    private Label updatedate;

    @FXML
    private Label updateby;
    @FXML
    private Label creationby;
    @FXML
    private Label username;
    @FXML
    private DatePicker startdate;
    @FXML
    private Button allRadacct;
    @FXML
    private DatePicker enddate;
    @FXML
    private Button clear1;

    @FXML
    private Button clear2;

    @FXML
    private Button clear3;

    @FXML
    private Button clear4;



    @FXML
    private Label lblilosc;

    private static final Logger logger = Logger.getLogger(Radusergroup.class.getName());
    ObservableList<String> VlanData = FXCollections.observableArrayList();
    private ObservableList<UserTableData> personData = FXCollections.observableArrayList();
    private ObservableList<UserTableData> userData = FXCollections.observableArrayList();
    private ObservableList<Radacct> radacctData = FXCollections.observableArrayList();
    private ObservableList<Radgroupreply> radgroupreplyData = FXCollections.observableArrayList();
    private IRadusergroupService serviceRadusergroup;
    private IRadcheckService serviceRadcheck;
    private IRadgroupreplyService serviceRadgroupreply;
    private IRadacctService serviceRadacct;
    private IUserinfoService userinfoService;
    private Integer VlanSelected;
    private String VlanGroupName = "*";
    ObservableList<String> masterDataa = FXCollections.observableArrayList();
    boolean copypassword;
    boolean live1 = false;
    boolean live2 = false;
    Progres pr = new Progres();
    Stage st = new Stage();
    public void initialize() {



    //    pr.run();

        Thread thread1 =  new Thread() {
            public void run() {

                initializeColumnsRadacct();

                live1=true;
            //    CloseProgres(live1,live2);

            }

        };
        Thread thread2 =  new Thread() {
            public void run() {
                initializeColumns();
                initVlanCombo();
                InitFilter();
                live2=true;
             //   CloseProgres(live1,live2);
        //        pr.shutdown();
            }
        };




        serviceRadusergroup = new RadusergroupService();
        serviceRadcheck = new RadcheckService();
        serviceRadgroupreply = new RadgroupreplyService();
        serviceRadacct = new RadacctService();
        AddClient.setVisible(false);
        thread1.start();
        thread2.start();

        TableColumn<Radacct, String> framedipaddress = new TableColumn<Radacct, String>("framedipaddress");
        TableColumn<Radacct, String> nasip = new TableColumn<Radacct, String>("nasip");
        TableColumn<Radacct, String> nasport = new TableColumn<Radacct, String>("nasport");
        TableColumn<Radacct, String> acctstarttime = new TableColumn<Radacct, String>("acctstarttime");
        TableColumn<Radacct, String> acctstoptime = new TableColumn<Radacct, String>("acctstoptime");
        TableRadacct.getColumns().setAll(framedipaddress, nasip, nasport, acctstarttime, acctstoptime);

        framedipaddress.setCellValueFactory(new PropertyValueFactory<Radacct, String>("framedIPAddress"));
        nasip.setCellValueFactory(new PropertyValueFactory<Radacct, String>("NASIPAddress"));
        nasport.setCellValueFactory(new PropertyValueFactory<Radacct, String>("NASPortId"));
        acctstarttime.setCellValueFactory(new PropertyValueFactory<Radacct, String>("acctStartTime"));
        acctstoptime.setCellValueFactory(new PropertyValueFactory<Radacct, String>("acctStopTime"));


     //   initializeColumns();
      //  initializeColumnsRadacct();

//        System.out.println("Przed startem :"+thread1.isAlive());
//       thread1.start();
//        System.out.println("Po starcie  :"+thread1.isAlive());
//
//
//
        //  MacAddress.textProperty().bind(find.textProperty());
        //     Stage stage2 = new Stage();
//        Progres pr =  new Progres();
//
//       //pr.startIndicator();
//        pr.start(stage2);




//        if (!live1==false) {
//            System.out.println("Clossses");
//            pr.Close(stage2);
//        }


        CloseProgres(live1,live2);

        assert personTable != null : "fx:id=\"Table\" was not injected: check your FXML file 'scene2.fxml'.";
    }

    private void CloseProgres(boolean live1, boolean live2) {

        System.out.println("Przekazano stan zadania 1"+live1);
        System.out.println("Przekazano stan zadania 2"+live2);

        if (live1==true) {
            System.out.println("Clossses");

        }

    }

    private void InitFilter() {
System.out.println("inicjalizacja sortowania");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = null;
      //  String.valueOf(sdfDate.format(myObject.getAcctStartTime()).matches((newValue.toString())))) {

   //     FilteredList<Radacct> filteredDataRadacct = new FilteredList<>(radacctData, p -> true);

//        enddate.valueProperty().addListener((observable ,oldValue,newValue)->{
//            filteredDataRadacct.setPredicate(myObject -> {
//                if (newValue == null) {
//                    return true;
//                }
//                if (String.valueOf(sdfDate.format(myObject.getAcctStopTime())).matches((newValue.toString()))) {
//                    return true;
//
//                } else
//                    return false;
//            });
//
//
//        });
//
//        startdate.valueProperty().addListener((observable ,oldValue,newValue)->{
//            filteredDataRadacct.setPredicate(myObject -> {
//                if (newValue == null) {
//                    return true;
//                }
//                if (String.valueOf(sdfDate.format(myObject.getAcctStartTime())).matches((newValue.toString()))) {
//                    return true;
//
//                } else
//                    return false;
//            });
//
//
//        });


        FilteredList<UserTableData> filteredData = new FilteredList<>(personData, p -> true);
        VlanGroup.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == "all") {

                    return true;
                }
                if (String.valueOf(myObject.getColvlan()).matches((newValue.toString()))) {

                    String.valueOf(myObject.getColvlan()).matches((newValue.toString()));
                    setLblilosc(Integer.toString(filteredData.size())+1);
                    return true;

                } else

                    return false;
            });
        });

        MacAddress.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(myObject.getColmacaddress()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                } else if (String.valueOf(myObject.getColmacpassword()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        find.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(myObject.getColmacaddress()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                } else if (String.valueOf(myObject.getColmacpassword()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(myObject.getColnotes()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(myObject.getColname()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(myObject.getColipaddress()).toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
                return false;
            });
        });





        SortedList<UserTableData> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(personTable.comparatorProperty());
        personTable.setItems(sortedData);


//        String ilosc = Integer.toString(personTable.getItems().size());
//        lblilosc.setText(ilosc);
//        SortedList<Radacct> sortedDataRadacct = new SortedList<>(filteredDataRadacct);
//        sortedDataRadacct.comparatorProperty().bind(TableRadacct.comparatorProperty());
//        TableRadacct.setItems(sortedDataRadacct);

    }

    public ObservableList<UserTableData> getRadduserData() {
        return personData;
    }

    private void initializeColumnsRadacct() {

        List<Radacct> RadacctList = null;
        try {
            RadacctList = serviceRadacct.getAllRadacct();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        InsertDataToTableRaddacct(RadacctList);


    }

    private void InsertDataToTableRaddacct(List<Radacct> radacctList) {

        Radacct radacct = new Radacct();
        radacctData.clear();
        for (Radacct r : radacctList) {

            radacct.setFramedIPAddress(r.getFramedIPAddress());
            radacct.setNASIPAddress(r.getNASIPAddress());
            radacct.setNASPortId(r.getNASPortId());
            radacct.setAcctStartTime(r.getAcctStartTime());
            radacct.setAcctStopTime(r.getAcctStopTime());
      //      System.out.println(r.getUserName());

            radacctData.add(radacct);

        }
        TableRadacct.setItems(radacctData);

        TableRadacct.setEditable(false);
    }

    private void initializeColumns() {
       // lblilosc= new Label();;
        lblilosc.setText("0");
        personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (personTable.getSelectionModel().getSelectedItem() != null) {
                //    System.out.println(personTable.getSelectionModel().getSelectedItem().getColmacaddress());
                    /////////Szukaj danych w Userinfo
                    userinfoService = new UserinfoService();
                    Userinfo userinfo = userinfoService.findUserInfo(personTable.getSelectionModel().getSelectedItem().getColmacaddress());
////////szukaj logow w Radacct
                    serviceRadacct = new RadacctService();
                    List<Radacct> RadacctList = serviceRadacct.getRadacctToMack(personTable.getSelectionModel().getSelectedItem().getColmacaddress().toString());

                    InsertDataToTableRaddacct(RadacctList);




                    if (userinfo.getFirstname() != null) {
                        firstname.setText(userinfo.getFirstname());
                    }
                    if (userinfo.getFirstname() != null) {
                        creationby.setText(userinfo.getCreationby());
                    }

                    if (userinfo.getNotes() != null) {
                        notes.setText(userinfo.getNotes());
                    }
                    if (userinfo.getUpdateby() != null) {
                        updateby.setText(userinfo.getUpdateby());
                    }


                    if (userinfo.getUpdatedate() != null) {
                        if (userinfo.getUpdatedate().toString().equals("0000-00-00 00:00:00")) {
                            updatedate.setText(userinfo.getUpdatedate().toString());
                        } else {
                            updatedate.setText("");

                        }

                    }
                    if (userinfo.getCreationdate() != null) {
                        if (userinfo.getCreationdate().toString().equals("0000-00-00 00:00:00")) {
                            creationdate.setText(userinfo.getCreationdate().toString());
                        } else {
                            creationdate.setText("");

                        }


                    }


                    username.setText(personTable.getSelectionModel().getSelectedItem().getColmacaddress());
                }
            }
        });
        TableColumn<UserTableData, String> colname = new TableColumn<UserTableData, String>("Name");
        TableColumn<UserTableData, String> colipaddress = new TableColumn<UserTableData, String>("IPAddress");
        TableColumn<UserTableData, String> colmacaddress = new TableColumn<UserTableData, String>("MacAddress");
        TableColumn<UserTableData, String> colmacpassword = new TableColumn<UserTableData, String>("MacPassword");
        TableColumn<UserTableData, String> colvlan = new TableColumn<UserTableData, String>("Vlan");
        TableColumn<UserTableData, String> colnotes = new TableColumn<UserTableData, String>("Opis");

        personTable.getColumns().setAll(colname,colipaddress, colmacaddress, colmacpassword, colvlan, colnotes);
        colname.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colname"));
        colmacaddress.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colmacaddress"));
        colipaddress.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colipaddress"));
        colmacpassword.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colmacpassword"));
        colvlan.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colvlan"));
        colnotes.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colnotes"));
        //	ObservableList<String> tmp = FXCollections.observableArrayList(initVlanCombo());
        colvlan.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), VlanData));
        //	colvlan.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), );
        colvlan.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<UserTableData, String>>() {
            public void handle(TableColumn.CellEditEvent<UserTableData, String> event) {
                System.out.println(event.getNewValue());
            }
        });

        List<UserTableData> userTableDataList = new ArrayList<UserTableData>();
        List<Radcheck> userList = serviceRadcheck.getAllHost();
        int allUsersSize = userList.size();


        userinfoService = new UserinfoService();
        for (Radcheck r : userList) {






            UserTableData userTableData = new UserTableData();
            List<Radacct> radacct =serviceRadacct.getIPRadacctToMack(r.getMacAddress());
            for(Radacct rr:radacct){
               userTableData.setColipaddress(rr.getFramedIPAddress());

            }


            userTableData.setColmacaddress(r.getUserName());

            userTableData.setColmacpassword(r.getPassword());
            Radusergroup group = serviceRadusergroup.getUserNameToGroup(r.getUserName());
           Userinfo userinfo = userinfoService.findUserInfo(r.getMacAddress());
                            userTableData.setColname(userinfo.getFirstname());
                            userTableData.setColnotes(userinfo.getNotes());
           Radgroupreply vlan = serviceRadgroupreply.getVlanbyGroup(group.getGroupName());
                               userTableData.setColvlan(vlan.getValue());
                                    userTableDataList.add(userTableData);

            Platform.runLater( () -> {
                setLblilosc(Integer.toString(userTableDataList.size()));



            });


        }


        //    pr.shutdown();



        userData.setAll(userTableDataList);
        personData.setAll(userTableDataList);
        personTable.setItems(userData);
        personTable.setEditable(true);
        checkMacPass.setSelected(true);

//        Platform.runLater(new Runnable() {
//            @Override public void run() {
//                setLblilosc(Integer.toString(userTableDataList.size()));
//            }
//        });





    }

    public void insertValue(KeyEvent keyEvent) {

        VisibleAddButton();


        if (MacAddress.getLength() <= 11) {

            if (this.status() == true) {
                MacPassword.textProperty().bind(MacAddress.textProperty());

            }
            if (this.status() == false) {
                MacPassword.textProperty().unbind();
            }
        } else {
            System.out.println("eeeee");
            LMaCAddress.setText("b��d");
        }
    }

    private void VisibleAddButton() {
        if (MacAddress.getLength() == 11) {
            AddClient.setVisible(true);
        } else {
            AddClient.setVisible(false);
        }
    }

    public boolean status() {

        if (checkMacPass.isSelected()) {
            copypassword = true;

        } else {
            copypassword = false;

        }
        return copypassword;
    }

    public void DodajHosta(ActionEvent actionEvent) {

        if ((MacPassword.getText().isEmpty()) && (MacAddress.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Pole Mac ", "Error", JOptionPane.ERROR_MESSAGE);
            AddClient.setVisible(false);
        } else {
            AddClient.setVisible(true);
            Radcheck user = new Radcheck(MacAddress.getText(), MacPassword.getText());
            Radusergroup usergroup = new Radusergroup(MacAddress.getText(), VlanGroupName);
            serviceRadusergroup.saveOrUpdate(usergroup);
            serviceRadcheck.saveOrUpdate(user);
            initializeColumns();
            InitFilter();
            MacAddress.setText("");
            if (checkMacPass.isSelected() != true) {
                MacPassword.setText("");
            }

        }
    }

    private List<String> initVlanCombo() {
        List<Radgroupreply> vlanlist = serviceRadgroupreply.getAllVlan();
        for (Radgroupreply c : vlanlist) {
            VlanData.add(c.getValue());
            masterDataa.add(c.getValue());
        }
        VlanData.add("all");
        VlanGroup.setItems(FXCollections.observableArrayList(VlanData)); //wstaw dane do combo
        return VlanData;
    }

    public void RightContextMenu(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().toString() == "SECONDARY") {
            System.out.println("prawy");
        }
    }

    public void Edytuj(ActionEvent actionEvent) {
//		System.out.println(personTable.getSelectionModel().getSelectedCells());
//		System.out.println(personTable.getSelectionModel().getSelectedItem().getMacAddress());
//		System.out.println(personTable.getSelectionModel().getSelectedItem().getAttribute());
    }

    private void logPerson(Radusergroup radusergroup) {
        logger.info(radusergroup.getGroupName() + ". " + radusergroup.getUserName() + " " + radusergroup.getPriority());
    }

    public Integer getSelectedVlan() {
        String selvlan = VlanGroup.getSelectionModel().getSelectedItem().toString();
        if (selvlan != "all") {
            VlanSelected = Integer.parseInt(selvlan);
            Radgroupreply groupname = serviceRadgroupreply.getGroupByVlan(selvlan); ///szukaj nazwy grupy
            VlanGroupName = groupname.getGroupName();
            return Integer.parseInt(selvlan);
        }
        return null;
    }

    public void DodajNas(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddNas.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Nas Add");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void DodajVlan(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddVlan.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Nas Add");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void AllRadacct(ActionEvent actionEvent) {
        initializeColumnsRadacct();
    }

    public void ClearData(ActionEvent actionEvent) {
        String idbutton = ((Button)actionEvent.getSource()).getId();

        switch (idbutton){
            case "clear1":
                        VlanGroup.getSelectionModel().selectLast();
                break;
            case "clear2":
              find.clear();
                break;
            case "clear3":
              MacAddress.clear();
                break;
            case "clear4":
             MacPassword.clear();
                break;

            default:

        }




    }
    public Label getLblilosc() {
        return lblilosc;
    }

    public void setLblilosc(String lblilosc) {
        this.lblilosc.setText(lblilosc);
    }
}
