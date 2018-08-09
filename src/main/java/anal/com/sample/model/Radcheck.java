package anal.com.sample.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the radcheck database table.
 * USER
 */
@Entity
@NamedQuery(name = "Radcheck.findAll", query = "SELECT r FROM Radcheck r")
@Table(name = "radcheck")
public class Radcheck implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "Attribute")
    private String Attribute;

    private String op;


    private String userName;
    @Column(name = "value")
    private String Password;

    public Radcheck() {
    }

    public Radcheck(String userName, String attribute, String op, String password) {
        this.userName = userName;
        this.Attribute = attribute;
        this.op = op;
        this.Password = password;

    }

    public Radcheck(String userName, String password) {
        this.userName = userName;
        this.Attribute = "Cleartext-Password";
        this.op = ":=";
        this.Password = password;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribute() {
        return this.Attribute;
    }

    public void setAttribute(String attribute) {
        this.Attribute = attribute;
    }

    public String getOp() {
        return this.op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.Password;
    }

    public List<Radcheck> getAllVlan() {


        return null;

    }

    public String getMacAddress() {
        return this.userName;
    }
}