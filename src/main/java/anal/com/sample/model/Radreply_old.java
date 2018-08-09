package anal.com.sample.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the radreply database table.
 */
@Entity
@NamedQuery(name = "Radreply_old.findAll", query = "SELECT r FROM Radreply_old r")
public class Radreply_old implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String attribute;

    private String op;

    private String userName;

    private String value;

    public Radreply_old() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
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

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}