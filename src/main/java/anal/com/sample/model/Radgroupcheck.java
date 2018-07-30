package anal.com.sample.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the radgroupcheck database table.
 * 
 */
@Entity
@NamedQuery(name="Radgroupcheck.findAll", query="SELECT r FROM Radgroupcheck r")
public class Radgroupcheck implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String attribute;

	private String groupName;

	private String op;

	private String value;

	public Radgroupcheck() {
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