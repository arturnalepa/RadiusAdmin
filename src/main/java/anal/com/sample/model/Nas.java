package anal.com.sample.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nas database table.
 * 
 */
@Entity
@NamedQuery(name="Nas.findAll", query="SELECT n FROM Nas n")
@Table(name = "nas")
public class Nas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String community;

	private String description;

	private String nasname;

	private int ports=1812;

	private String secret;

	private String shortname;

	private String type;

	public Nas() {
	}

	public Nas(String community, String description, String nasname, int ports, String secret, String shortname, String type) {
		this.community = community;
		this.description = description;
		this.nasname = nasname;
		this.ports = ports;
		this.secret = secret;
		this.shortname = shortname;
		this.type = type;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommunity() {
		return this.community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNasname() {
		return this.nasname;
	}

	public void setNasname(String nasname) {
		this.nasname = nasname;
	}

	public int getPorts() {
			return this.ports;
	}

	public void setPorts(int ports) {
		this.ports = ports;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}