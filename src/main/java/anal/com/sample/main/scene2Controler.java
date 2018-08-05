package anal.com.sample.main;

import anal.com.sample.model.Radcheck;
import anal.com.sample.model.Radgroupreply;
import anal.com.sample.model.Radusergroup;
import anal.com.sample.repository.service.IRadcheckService;
import anal.com.sample.repository.service.IRadgroupreplyService;
import anal.com.sample.repository.service.IRadusergroupService;
import anal.com.sample.service.service.RadcheckService;
import anal.com.sample.service.service.RadgroupreplyService;
import anal.com.sample.service.service.RadusergroupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
//import org.springframework.transaction.annotation.Transactional;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
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
	 TableView<UserTableData> personTable ;
	@FXML
	private TableColumn<UserTableData,String> colname;
	@FXML
	private TableColumn<UserTableData,String> colmacaddress;
	@FXML
	private TableColumn<UserTableData, String> colmacpassword;
	@FXML
	private TableColumn<UserTableData,String> colvlan;
	private static final Logger logger = Logger.getLogger(Radusergroup.class.getName());
	ObservableList<String> VlanData = FXCollections.observableArrayList();
	@FXML
    private ObservableList<UserTableData> personData = FXCollections.observableArrayList();
	private ObservableList<UserTableData> userData = FXCollections.observableArrayList();
	//private List<String> VlanData = FXCollections.observableArrayList();
	private ObservableList<Radgroupreply> radgroupreplyData = FXCollections.observableArrayList();
	private IRadusergroupService serviceRadusergroup;
	private IRadcheckService serviceRadcheck;
	private IRadgroupreplyService serviceRadgroupreply;
	private Integer VlanSelected;
	private String VlanGroupName="*";
	ObservableList<String> masterDataa = FXCollections.observableArrayList();
	boolean copypassword;



	public void  initialize() {

		serviceRadusergroup = new RadusergroupService();
		serviceRadcheck = new RadcheckService();
		serviceRadgroupreply = new RadgroupreplyService();
		//InsertTestData(); //dane testowe

		AddClient.setVisible(false);
        initializeColumns();
		//ObservableList<String> tm = FXCollections.observableArrayList(initVlanCombo());
		initVlanCombo();
	//	PObierzDaneDoTabeli(VlanGroupName);



		assert personTable != null : "fx:id=\"Table\" was not injected: check your FXML file 'scene2.fxml'.";

	}


	private void PObierzDaneDoTabeli(String VlanGroupName) {

		List<UserTableData> userTableDataList=new ArrayList<UserTableData>();
		List<Radcheck> userList = serviceRadcheck.getAllHost();

		for(Radcheck r :userList){


		//	System.out.println(serviceRadusergroup.getGroupbyVlan(VlanGroupName));  ///zreaca nr vlanu

			UserTableData userTableData = new UserTableData();
			userTableData.setColvlan(serviceRadusergroup.getGroupbyVlan(VlanGroupName));
			userTableData.setColmacaddress(r.getUserName());
			userTableData.setColmacpassword(r.getPassword());
			userTableDataList.add(userTableData);


		}



		userData.setAll(userTableDataList);
		personData.setAll(userTableDataList);
		personTable.setItems(userData);
		personTable.setEditable(true);

		}

	public ObservableList<UserTableData> getRadduserData() {
    	        return personData;
    }

	private void initializeColumns() {
		TableColumn<UserTableData, String> colname   = new TableColumn<UserTableData, String>("Name");
    	 TableColumn<UserTableData, String> colmacaddress   = new TableColumn<UserTableData, String>("MacAddress");
         TableColumn<UserTableData, String> colmacpassword   = new TableColumn<UserTableData, String>("MacPassword");
         TableColumn<UserTableData, String> colvlan   = new TableColumn<UserTableData, String>("Vlan");

         personTable.getColumns().setAll(colname,colmacaddress,colmacpassword,colvlan);
		colname.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colname"));
        colmacaddress.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colmacaddress"));
        colmacpassword.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colmacpassword"));
        colvlan.setCellValueFactory(new PropertyValueFactory<UserTableData, String>("colvlan"));
	//	ObservableList<String> tmp = FXCollections.observableArrayList(initVlanCombo());
		colvlan.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), VlanData));
	//	colvlan.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), );
		 		colvlan.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<UserTableData, String>>() {
			public void handle(TableColumn.CellEditEvent<UserTableData, String> event) {
				System.out.println(event.getNewValue());
			}
		});




		List<UserTableData> userTableDataList=new ArrayList<UserTableData>();
		List<Radcheck> userList = serviceRadcheck.getAllHost();

		for(Radcheck r :userList){


			UserTableData userTableData = new UserTableData();
			userTableData.setColmacaddress(r.getUserName());
			userTableData.setColmacpassword(r.getPassword());
			userTableData.setColvlan(serviceRadgroupreply.
					getVlanbyGroup(serviceRadusergroup.getUserNameToGroup(r.getUserName())
							.getGroupName()).getValue());

//wez username sprawdz w jakiej jest grupie
			//wez grupe i zobacz jaki to vlan
			//podstaw vlan do smiennej
//Radgroupreply groupname to vla
//radusergroup username to groupname


			userTableDataList.add(userTableData);



		}


//personData.setAll(userList);
		userData.setAll(userTableDataList);
		personData.setAll(userTableDataList);
		personTable.setItems(userData);
		personTable.setEditable(true);









	checkMacPass.setSelected(true);


    }

	private void InsertTestData() {
//		Radusergroup p1 = new Radusergroup("user1", "groupa1");
//		Radusergroup p2 = new Radusergroup("user2", "groupa2");
//		Radusergroup p3 = new Radusergroup("user3", "groupa3");
//		Radusergroup p4 = new Radusergroup("user4", "groupa4");
//		Radusergroup p5 = new Radusergroup("user5", "groupa5");
//		Radusergroup p6 = new Radusergroup("user6", "groupa6");
//		serviceRadusergroup.saveOrUpdate(p1);
//		serviceRadusergroup.saveOrUpdate(p2);
//		serviceRadusergroup.saveOrUpdate(p3);
//		serviceRadusergroup.saveOrUpdate(p4);
//		serviceRadusergroup.saveOrUpdate(p5);
//		serviceRadusergroup.saveOrUpdate(p6);
		//serviceRadcheck.saveOrUpdate(new Radcheck("username1", "Cleartext-Password", ":=", "password1"));


		//serviceRadgroupreply.saveOrUpdate(new Radgroupreply("","","",""));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa1", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa1", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa1", "Tunnel-Private-Group-ID", ":=", "221"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan22", "Tunnel-Type", ":=", "VLAN"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan22", "Tunnel-Medium-Type", ":=", "IEEE-802"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan22", "Tunnel-Private-Group-ID", ":=", "22"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan30", "Tunnel-Type", ":=", "VLAN"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan30", "Tunnel-Medium-Type", ":=", "IEEE-802"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan30", "Tunnel-Private-Group-ID", ":=", "30"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan100", "Tunnel-Type", ":=", "VLAN"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan100", "Tunnel-Medium-Type", ":=", "IEEE-802"));
		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("Vlan100", "Tunnel-Private-Group-ID", ":=", "100"));

//		serviceNas.saveOrUpdate(new Nas("Nas1","opis1","Name1",
//		1812,"passwd1","krótka nazwa","typ1"));
//		serviceNas.saveOrUpdate(new Nas("Nas2","opis2","Name2",
//				1812,"passwd2","krótka nazwa2","typ2"));
//		serviceNas.saveOrUpdate(new Nas("Nas3","opis3","Name3",
//				1812,"passwd3","krótka nazwa3","typ3"));
//		serviceNas.saveOrUpdate(new Nas("Nas4","opis4","Name4",
//				1812,"passwd4","krótka nazwa4","typ2"));

	}

	public void insertValue(KeyEvent keyEvent) {

		VisibleAddButton();


		if(MacAddress.getLength()<=11){

    	if (this.status()==true)
		{
		MacPassword.textProperty().bind(MacAddress.textProperty());

	}
		if (this.status()==false){
			MacPassword.textProperty().unbind();


	}}
	else{
			System.out.println("eeeee");
			LMaCAddress.setText("b³¹d");
		//	MacAddress.setFont(Font.font ("Verdana", 20));


		}
}

	private void VisibleAddButton() {
		if(MacAddress.getLength()==11){
			AddClient.setVisible(true);
		}else{
			AddClient.setVisible(false);
		}
	}

	public boolean status() {

		if (checkMacPass.isSelected()){
			copypassword = true;

		}
		else{
			copypassword = false;

		}
		return copypassword;
	}

	public void DodajHosta(ActionEvent actionEvent) {

    	if ((MacPassword.getText().isEmpty())&&(MacAddress.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Pole Mac ","Error",JOptionPane.ERROR_MESSAGE);
			AddClient.setVisible(false);
		}
		else{
			AddClient.setVisible(true);
			// public Radcheck(String userName, String attribute, String op, String password){
			Radcheck user = new Radcheck(MacAddress.getText(),MacPassword.getText());
			Radusergroup usergroup = new Radusergroup(MacAddress.getText(),VlanGroupName);
			serviceRadusergroup.saveOrUpdate(usergroup);
			serviceRadcheck.saveOrUpdate(user);
//			PObierzDaneDoTabeli(VlanGroupName);
			initializeColumns();
		MacAddress.setText("");
		if(checkMacPass.isSelected()!=true){
		MacPassword.setText("");
		}
	//	System.out.println(MacAddress.getText()+MacPassword.getText()+VlanGroup.getSelectionModel().getSelectedItem().toString());
	}}

	private List<String> initVlanCombo(){
		List<Radgroupreply> vlanlist = serviceRadgroupreply.getAllVlan();
		for (Radgroupreply c : vlanlist) {
	VlanData.add(c.getValue());
	masterDataa.add(c.getValue());
					}
	VlanGroup.setItems(FXCollections.observableArrayList(VlanData)); //wstaw dane do combo
		return VlanData;
	}

	public void RightContextMenu(MouseEvent mouseEvent) {


			if (mouseEvent.getButton().toString()=="SECONDARY"){
				System.out.println( "prawy");
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

	public Integer  getSelectedVlan() {
///Integer.parseInt(

		//serviceRadcheck.getGroupByVlanId((Integer) VlanGroup.getSelectionModel().getSelectedItem());

//		System.out.println(VlanGroup.getSelectionModel().getSelectedItem());
		String selvlan = VlanGroup.getSelectionModel().getSelectedItem().toString();
		//selvlan.toString();
	//	serviceRadcheck.getGroupByVlanId(Integer.parseInt(selvlan));
		System.out.println(selvlan);
	//	System.out.println(serviceRadcheck.getGroupByVlanId(Integer.parseInt(	vlanid.toString())));
	//	PObierzDaneDoTabeli(selvlan);
		VlanSelected=Integer.parseInt(selvlan);
		Radgroupreply groupname = serviceRadgroupreply.getGroupByVlan(selvlan); ///szukaj nazwy grupy
		VlanGroupName=groupname.getGroupName();


return Integer.parseInt(selvlan) ;
	}

	public void DodajNas(ActionEvent actionEvent) throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AddNas.fxml"));
		stage.setScene(new Scene(root));
		stage.setTitle("Nas Add");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.show();


	}

	public void DodajVlan(ActionEvent actionEvent) {
	}
}
