package anal.com.sample.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the userbillinfo database table.
 *
 */
@Entity
@NamedQuery(name="Userbillinfo.findAll", query="SELECT u FROM Userbillinfo u")
public class Userbillinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @Column(name = "batch_id")
    private int batchId;

    private int billdue;

    private String billstatus;

    private String cash;

    private String changeuserbillinfo;

    private String city;

    private String company;

    private String contactperson;

    private String country;

    private String coupon;

    private String creationby;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;

    private String creditcardexp;

    private String creditcardname;

    private String creditcardnumber;

    private String creditcardtype;

    private String creditcardverification;

    private String email;

    private String emailinvoice;

    private String faxinvoice;

    @Column(name = "hotspot_id")
    private int hotspotId;

    private String hotspotlocation;

    @Temporal(TemporalType.DATE)
    private Date lastbill;

    private String lead;

    @Temporal(TemporalType.DATE)
    private Date nextbill;

    private int nextinvoicedue;

    private String notes;

    private String ordertaker;

    private String paymentmethod;

    private String phone;

    private String planName;

    private String postalinvoice;

    private String state;

    private String updateby;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;

    private String username;

    private String zip;

    public Userbillinfo() {
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

    public int getBatchId() {
        return this.batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getBilldue() {
        return this.billdue;
    }

    public void setBilldue(int billdue) {
        this.billdue = billdue;
    }

    public String getBillstatus() {
        return this.billstatus;
    }

    public void setBillstatus(String billstatus) {
        this.billstatus = billstatus;
    }

    public String getCash() {
        return this.cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getChangeuserbillinfo() {
        return this.changeuserbillinfo;
    }

    public void setChangeuserbillinfo(String changeuserbillinfo) {
        this.changeuserbillinfo = changeuserbillinfo;
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

    public String getContactperson() {
        return this.contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
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

    public String getCreditcardexp() {
        return this.creditcardexp;
    }

    public void setCreditcardexp(String creditcardexp) {
        this.creditcardexp = creditcardexp;
    }

    public String getCreditcardname() {
        return this.creditcardname;
    }

    public void setCreditcardname(String creditcardname) {
        this.creditcardname = creditcardname;
    }

    public String getCreditcardnumber() {
        return this.creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getCreditcardtype() {
        return this.creditcardtype;
    }

    public void setCreditcardtype(String creditcardtype) {
        this.creditcardtype = creditcardtype;
    }

    public String getCreditcardverification() {
        return this.creditcardverification;
    }

    public void setCreditcardverification(String creditcardverification) {
        this.creditcardverification = creditcardverification;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailinvoice() {
        return this.emailinvoice;
    }

    public void setEmailinvoice(String emailinvoice) {
        this.emailinvoice = emailinvoice;
    }

    public String getFaxinvoice() {
        return this.faxinvoice;
    }

    public void setFaxinvoice(String faxinvoice) {
        this.faxinvoice = faxinvoice;
    }

    public int getHotspotId() {
        return this.hotspotId;
    }

    public void setHotspotId(int hotspotId) {
        this.hotspotId = hotspotId;
    }

    public String getHotspotlocation() {
        return this.hotspotlocation;
    }

    public void setHotspotlocation(String hotspotlocation) {
        this.hotspotlocation = hotspotlocation;
    }

    public Date getLastbill() {
        return this.lastbill;
    }

    public void setLastbill(Date lastbill) {
        this.lastbill = lastbill;
    }

    public String getLead() {
        return this.lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public Date getNextbill() {
        return this.nextbill;
    }

    public void setNextbill(Date nextbill) {
        this.nextbill = nextbill;
    }

    public int getNextinvoicedue() {
        return this.nextinvoicedue;
    }

    public void setNextinvoicedue(int nextinvoicedue) {
        this.nextinvoicedue = nextinvoicedue;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOrdertaker() {
        return this.ordertaker;
    }

    public void setOrdertaker(String ordertaker) {
        this.ordertaker = ordertaker;
    }

    public String getPaymentmethod() {
        return this.paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlanName() {
        return this.planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPostalinvoice() {
        return this.postalinvoice;
    }

    public void setPostalinvoice(String postalinvoice) {
        this.postalinvoice = postalinvoice;
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

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}