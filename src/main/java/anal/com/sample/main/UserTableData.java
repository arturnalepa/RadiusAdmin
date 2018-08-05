package anal.com.sample.main;

public class UserTableData {

    private String colname;

    private String colmacaddress;

    private String colmacpassword;

    private String colvlan;

    public UserTableData() {

    }

    public UserTableData(String colname, String colmacaddress, String colmacpassword, String colvlan) {
        this.colname = colname;
        this.colmacaddress = colmacaddress;
        this.colmacpassword = colmacpassword;
        this.colvlan = colvlan;
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
