package anal.com.sample.model;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.security.Timestamp;

/**
 * The persistent class for the radpostauth database table.
 */
@Entity
@NamedQuery(name = "Radpostauth.findAll", query = "SELECT r FROM Radpostauth r")
public class Radpostauth implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp authdate;

    private String pass;

    private String reply;

    private String username;

    public Radpostauth() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getAuthdate() {
        return this.authdate;
    }

    public void setAuthdate(Timestamp authdate) {
        this.authdate = authdate;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getReply() {
        return this.reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}