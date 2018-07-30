package anal.com.sample.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the radcheck database table.
 * 
 */
@Entity
@NamedQuery(name="Radcheck.findAll", query="SELECT r FROM Radcheck r")
public class Radcheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String Attribute;

	private String op;

	private String userName;
@Column(name = "value")
	private String Vlan;
	public Radcheck() {
	}

    public Radcheck(String userName, String attribute, String op, String Vlan){
	    this.userName=userName;
	    this.Attribute=attribute;
	    this.op=op;
	    this.Vlan=Vlan;

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

	public String getVlan() {
		return this.Vlan;
	}

    public List<Radcheck> getAllVlan(){


	    return null;

    }
	public String getMacAddress() {
		return this.userName;
	}
}