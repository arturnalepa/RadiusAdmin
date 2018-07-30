package anal.com.sample.main;

import anal.com.sample.model.Nas;
import anal.com.sample.model.Radcheck;
import anal.com.sample.model.Radgroupreply;
import anal.com.sample.model.Radusergroup;
import anal.com.sample.repository.service.INasService;
import anal.com.sample.repository.service.IRadcheckService;
import anal.com.sample.repository.service.IRadgroupreplyService;
import anal.com.sample.repository.service.IRadusergroupService;
import anal.com.sample.service.service.NasService;
import anal.com.sample.service.service.RadcheckService;
import anal.com.sample.service.service.RadgroupreplyService;
import anal.com.sample.service.service.RadusergroupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

import javax.swing.*;
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
 TableView<Radcheck> personTable ;
	@FXML
	private TableColumn<Radcheck,String> colmacaddress;
	@FXML
	private TableColumn<Radcheck, String> colmacpassword;
	@FXML
	private TableColumn<Radcheck,String> colvlan;
	private static final Logger logger = Logger.getLogger(Radusergroup.class.getName());
	ObservableList<String> VlanData = FXCollections.observableArrayList();

	@FXML
    private ObservableList<Radcheck> personData = FXCollections.observableArrayList();
	//private List<String> VlanData = FXCollections.observableArrayList();
	private ObservableList<Radgroupreply> radgroupreplyData = FXCollections.observableArrayList();
	private IRadusergroupService serviceRadusergroup;
	private IRadcheckService serviceRadcheck;
	private IRadgroupreplyService serviceRadgroupreply;
	private INasService serviceNas;

	ObservableList<String> masterDataa = FXCollections.observableArrayList();
	boolean copypassword;



	public void  initialize() {

		serviceRadusergroup = new RadusergroupService();
		serviceRadcheck = new RadcheckService();
		serviceRadgroupreply = new RadgroupreplyService();
		serviceNas = new NasService();


		InsertTestData();
		initVlanComboinTable();
		AddClient.setVisible(false);
        initializeColumns();
		ObservableList<String> tm = FXCollections.observableArrayList(initVlanCombo());
	//	ObservableList<Radgroupreply> observableList = FXCollections.observableList(initVlanCombo());

		PObierzDaneDoTabeli();



		assert personTable != null : "fx:id=\"Table\" was not injected: check your FXML file 'scene2.fxml'.";

	}


	private void PObierzDaneDoTabeli() {


	}



	public ObservableList<Radcheck> getRadduserData() {
    	        return personData;
    }

	private void initializeColumns() {
    	 TableColumn<Radcheck, String> colmacaddress   = new TableColumn<Radcheck, String>("MacAddress");
         TableColumn<Radcheck, String> colmacpassword   = new TableColumn<Radcheck, String>("MacPassword");
         TableColumn<Radcheck, String> colvlan   = new TableColumn<Radcheck, String>("Vlan");

         personTable.getColumns().setAll(colmacaddress,colmacpassword,colvlan);

        colmacaddress.setCellValueFactory(new PropertyValueFactory<Radcheck, String>("MacAddress"));
        colmacpassword.setCellValueFactory(new PropertyValueFactory<Radcheck, String>("MacPassword"));
        colvlan.setCellValueFactory(new PropertyValueFactory<Radcheck, String>("Vlan"));
	//	ObservableList<Radgroupreply> tmp = FXCollections.observableArrayList(initVlanCombo());
	//	colvlan.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), VlanData));
	//	colvlan.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), );
		colvlan.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Radcheck, String>>() {
			public void handle(TableColumn.CellEditEvent<Radcheck, String> event) {
				System.out.println(event.getNewValue());
			}
		});

    personTable.setItems(getRadduserData());
	personTable.setEditable(true);
	checkMacPass.setSelected(true);


    }

	private List<String> initVlanComboinTable() {


		return null;
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
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa1", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa1", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa1", "Tunnel-Private-Group-ID", ":=", "221"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa2", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa2", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa2", "Tunnel-Private-Group-ID", ":=", "22"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa3", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa3", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa3", "Tunnel-Private-Group-ID", ":=", "30"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa4", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa4", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa4", "Tunnel-Private-Group-ID", ":=", "100"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa5", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa5", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadcheck.saveOrUpdate(new Radcheck("groupa5", "Tunnel-Private-Group-ID", ":=", "1"));
//
//
//		//serviceRadgroupreply.saveOrUpdate(new Radgroupreply("","","",""));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Private-Group-ID", ":=", "1"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Private-Group-ID", ":=", "1"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Private-Group-ID", ":=", "1"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Type", ":=", "VLAN"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Medium-Type", ":=", "IEEE-802"));
//		serviceRadgroupreply.saveOrUpdate(new Radgroupreply("groupa5", "Tunnel-Private-Group-ID", ":=", "1"));

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
			Radusergroup r = new Radusergroup(MacAddress.getText(), "groupa6");
			serviceRadusergroup.saveOrUpdate(r);
	//	radgroupreply.add(new Radcheck(MacAddress.getText(),MacPassword.getText(),VlanGroup.getSelectionModel().getSelectedItem().toString()));

			//radgroupreplyData.add(new Radgroupreply().InitRadgroupreply("grupa1","111"));
///dodanie do bazy danych
		//	DaoRadgroupreply rr = new DaoRadgroupreply();
		//	rr.InsertToRadgroupreply("grupa2","22222");


		MacAddress.setText("");
		if(checkMacPass.isSelected()!=true){
		MacPassword.setText("");
		}
	//	System.out.println(MacAddress.getText()+MacPassword.getText()+VlanGroup.getSelectionModel().getSelectedItem().toString());
	}}

	private List<String> initVlanCombo(){

		List<Radcheck> lradcheck = serviceRadcheck.getAllVlan();
		for (Radcheck c : lradcheck) {
		//	VlanData.add(c.getVlan());
	//		masterDataa.add(c.getVlan());
				}
		VlanGroup.setItems(FXCollections.observableArrayList(VlanData)); //wstaw dane do combo
		VlanGroup.setValue("Vlan");
		return VlanData;
	}

	public void RightContextMenu(MouseEvent mouseEvent) {


			if (mouseEvent.getButton().toString()=="SECONDARY"){
				System.out.println( "prawy");
			}
	}

	public void Edytuj(ActionEvent actionEvent) {

		System.out.println(personTable.getSelectionModel().getSelectedCells());
		System.out.println(personTable.getSelectionModel().getSelectedItem().getMacAddress());
		System.out.println(personTable.getSelectionModel().getSelectedItem().getAttribute());




    }

	private void logPerson(Radusergroup radusergroup) {
		logger.info(radusergroup.getGroupName() + ". " + radusergroup.getUserName() + " " + radusergroup.getPriority());
	}

	public void getSelectedVlan(ActionEvent actionEvent) {

System.out.println(VlanGroup.getSelectionModel().getSelectedItem().toString());
		serviceRadcheck.getGroupByVlanId((Integer) VlanGroup.getSelectionModel().getSelectedItem());

	}
}
