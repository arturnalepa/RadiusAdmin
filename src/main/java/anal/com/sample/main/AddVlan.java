package anal.com.sample.main;

import anal.com.sample.model.Radgroupreply;
import anal.com.sample.repository.service.IRadgroupreplyService;
import anal.com.sample.service.service.RadgroupreplyService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddVlan {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField vlanname;

    @FXML
    private TextField vlannumber;

    @FXML
    private Button AddVlan;
    private IRadgroupreplyService serviceRadgroupreply;

    public AddVlan() {

    }

    @FXML
    void initialize() {
        assert vlanname != null : "fx:id=\"vlanname\" was not injected: check your FXML file 'AddVlan.fxml'.";
        assert vlannumber != null : "fx:id=\"vlannumber\" was not injected: check your FXML file 'AddVlan.fxml'.";
        assert AddVlan != null : "fx:id=\"AddVlan\" was not injected: check your FXML file 'AddVlan.fxml'.";

    }

    public void VlanAdd() {
        serviceRadgroupreply = new RadgroupreplyService();
        serviceRadgroupreply.saveOrUpdate(new Radgroupreply(vlanname.getText(), "Tunnel-Type", ":=", "VLAN"));
        serviceRadgroupreply.saveOrUpdate(new Radgroupreply(vlanname.getText(), "Tunnel-Medium-Type", ":=", "IEEE-802"));
        serviceRadgroupreply.saveOrUpdate(new Radgroupreply(vlanname.getText(), "Tunnel-Private-Group-ID", ":=", vlannumber.getText()));
    }
}
