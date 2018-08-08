package anal.com.sample.main;

public class UserTableData {

    private String colname;

    private String colmacaddress;

    private String colmacpassword;

    private String colvlan;

    private String colnotes;


    public UserTableData() {

    }

    public UserTableData(String colname, String colmacaddress, String colmacpassword, String colvlan, String colnotes) {
        this.colname = colname;
        this.colmacaddress = colmacaddress;
        this.colmacpassword = colmacpassword;
        this.colvlan = colvlan;
        this.colnotes = colnotes;
    }


    public String getColnotes() {
        return colnotes;
    }

    public void setColnotes(String colnotes) {
        this.colnotes = colnotes;
    }

    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }

    public String getColmacaddress() {
        return colmacaddress;
    }

    public void setColmacaddress(String colmacaddress) {
        this.colmacaddress = colmacaddress;
    }

    public String getColmacpassword() {
        return colmacpassword;
    }

    public void setColmacpassword(String colmacpassword) {
        this.colmacpassword = colmacpassword;
    }

    public String getColvlan() {
        return colvlan;
    }

    public void setColvlan(String colvlan) {
        this.colvlan = colvlan;
    }
}
