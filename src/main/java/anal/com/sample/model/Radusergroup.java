package anal.com.sample.model;
import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the radusergroup database table.
 * 
 */
@Entity
@NamedQuery(name="Radusergroup.findAll", query="SELECT r FROM Radusergroup r")
@Table(name = "radusergroup")
public class Radusergroup  implements Serializable {
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue
//	private int id;
	@Id
	private String groupName;

	private int priority;

	private String userName;

	public Radusergroup() {

	}
	public Radusergroup(String userName, String groupName){
this.userName=userName;
this.groupName=groupName;

	}
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Radcheck getGroupByVlanId(int id){
		return null;

	}
}