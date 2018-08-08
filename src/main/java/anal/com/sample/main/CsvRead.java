package anal.com.sample.main;

import javafx.beans.property.SimpleStringProperty;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvRead {

    private SimpleStringProperty Computer, Description, IP, MAC;

    public CsvRead(String computer, String description, String IP, String MAC) {
        this.Computer = new SimpleStringProperty(computer);
        this.Description = new SimpleStringProperty(description);
        this.IP = new SimpleStringProperty(IP);
        this.MAC = new SimpleStringProperty(MAC);
    }

    public String getComputer() {
        return Computer.get();
    }

    public SimpleStringProperty computerProperty() {
        return Computer;
    }

    public String getDescription() {
        return Description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return Description;
    }

    public String getIP() {
        return IP.get();
    }

    public SimpleStringProperty IPProperty() {
        return IP;
    }

    public String getMAC() {
        return MAC.get();
    }

    public SimpleStringProperty MACProperty() {
        return MAC;
    }

}
