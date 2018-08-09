package anal.com.sample.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the radgroupcheck database table.
 */
@Entity
@NamedQuery(name = "Radgroupcheck_old.findAll", query = "SELECT r FROM Radgroupcheck_old r")
public class Radgroupcheck_old implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String attribute;

    private String groupName;

    private String op;

    private String value;

    public Radgroupcheck_old() {
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

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOp() {
        return this.op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}