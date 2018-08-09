package anal.com.sample.model;


import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the userinfo database table.
 */
@Entity
@NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u")
@Table(name = "userinfo")
public class Userinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    private String changeuserinfo;

    private String city;

    private String company;

    private String country;

    private String creationby;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;

    private String department;

    private String email;

    private int enableportallogin;

    private String firstname;

    private String homephone;

    private String lastname;

    private String mobilephone;

    private String notes;

    private String portalloginpassword;

    private String state;

    private String updateby;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;

    private String username;

    private String workphone;

    private String zip;

    public Userinfo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChangeuserinfo() {
        return this.changeuserinfo;
    }

    public void setChangeuserinfo(String changeuserinfo) {
        this.changeuserinfo = changeuserinfo;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreationby() {
        return this.creationby;
    }

    public void setCreationby(String creationby) {
        this.creationby = creationby;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnableportallogin() {
        return this.enableportallogin;
    }

    public void setEnableportallogin(int enableportallogin) {
        this.enableportallogin = enableportallogin;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getHomephone() {
        return this.homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobilephone() {
        return this.mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPortalloginpassword() {
        return this.portalloginpassword;
    }

    public void setPortalloginpassword(String portalloginpassword) {
        this.portalloginpassword = portalloginpassword;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUpdateby() {
        return this.updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWorkphone() {
        return this.workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}