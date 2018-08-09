package anal.com.sample.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 AcctStartTime - czas rozpoczêcia sesji
 AcctStopTime - czas zatrzymania sesji
 AcctSessionTime - czas sesji w sekundach
 AcctInputOctects - iloœæ danych wys³anych przez u¿ytkownika
 AcctOutputOctects - iloœæ danych odebranych przez u¿ytkownika
 CalledStationId - identyfikator NAS, który obs³ugiwa³ sesjê
 AcctTerminationCause - co spowodowa³o wylogowanie u¿ytkownika
 CalledStationID - adres MAC urz¹dzenia, z którego u¿ytkownik siê zalogowa³
 w
 FramedIPAddress - adres IP urz¹dzenia, z którego u¿ytkownik siê zalogowa³
 ou will have to uncomment certain lines in order to enable logging:

 From the authorize section in /etc/raddb/sites-enabled/default file:

 #
 #  If you want to have a log of authentication requests,
 #  un-comment the following line, and the 'detail auth_log'
 #  section, above.
 #      auth_log

 From the post-auth section in /etc/raddb/sites-enabled/default file:

 #
 #  If you want to have a log of authentication replies,
 #  un-comment the following line, and the 'detail reply_log'
 #  section, above.
 #      reply_log


 */
@Entity
@Table(name = "radacct")
@NamedQuery(name="Radacct.findAll", query="SELECT r FROM Radacct r")
public class Radacct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private String radAcctId;

	private String acctAuthentic;

	private BigInteger acctInputOctets;

	private BigInteger acctOutputOctets;

	private String acctSessionId;

	private int acctSessionTime;

	private int acctStartDelay;

	@Temporal(TemporalType.TIMESTAMP)
	private Date acctStartTime;

	private int acctStopDelay;

	@Temporal(TemporalType.TIMESTAMP)
	private Date acctStopTime;

	private String acctTerminateCause;

	private String acctUniqueId;

	private String calledStationId;

	private String callingStationId;

	private String connectInfo_start;

	private String connectInfo_stop;

	private String framedIPAddress;

	private String framedProtocol;

	private String NASIPAddress;

	private String NASPortId;

	private String NASPortType;

	private String realm;

	private String serviceType;

	private String userName;

	public Radacct() {
	}

	public String getRadAcctId() {
		return this.radAcctId;
	}

	public void setRadAcctId(String radAcctId) {
		this.radAcctId = radAcctId;
	}

	public String getAcctAuthentic() {
		return this.acctAuthentic;
	}

	public void setAcctAuthentic(String acctAuthentic) {
		this.acctAuthentic = acctAuthentic;
	}

	public BigInteger getAcctInputOctets() {
		return this.acctInputOctets;
	}

	public void setAcctInputOctets(BigInteger acctInputOctets) {
		this.acctInputOctets = acctInputOctets;
	}

	public BigInteger getAcctOutputOctets() {
		return this.acctOutputOctets;
	}

	public void setAcctOutputOctets(BigInteger acctOutputOctets) {
		this.acctOutputOctets = acctOutputOctets;
	}

	public String getAcctSessionId() {
		return this.acctSessionId;
	}

	public void setAcctSessionId(String acctSessionId) {
		this.acctSessionId = acctSessionId;
	}

	public int getAcctSessionTime() {
		return this.acctSessionTime;
	}

	public void setAcctSessionTime(int acctSessionTime) {
		this.acctSessionTime = acctSessionTime;
	}

	public int getAcctStartDelay() {
		return this.acctStartDelay;
	}

	public void setAcctStartDelay(int acctStartDelay) {
		this.acctStartDelay = acctStartDelay;
	}

	public Date getAcctStartTime() {
		return this.acctStartTime;
	}

	public void setAcctStartTime(Date acctStartTime) {
		this.acctStartTime = acctStartTime;
	}

	public int getAcctStopDelay() {
		return this.acctStopDelay;
	}

	public void setAcctStopDelay(int acctStopDelay) {
		this.acctStopDelay = acctStopDelay;
	}

	public Date getAcctStopTime() {
		return this.acctStopTime;
	}

	public void setAcctStopTime(Date acctStopTime) {
		this.acctStopTime = acctStopTime;
	}

	public String getAcctTerminateCause() {
		return this.acctTerminateCause;
	}

	public void setAcctTerminateCause(String acctTerminateCause) {
		this.acctTerminateCause = acctTerminateCause;
	}

	public String getAcctUniqueId() {
		return this.acctUniqueId;
	}

	public void setAcctUniqueId(String acctUniqueId) {
		this.acctUniqueId = acctUniqueId;
	}

	public String getCalledStationId() {
		return this.calledStationId;
	}

	public void setCalledStationId(String calledStationId) {
		this.calledStationId = calledStationId;
	}

	public String getCallingStationId() {
		return this.callingStationId;
	}

	public void setCallingStationId(String callingStationId) {
		this.callingStationId = callingStationId;
	}

	public String getConnectInfo_start() {
		return this.connectInfo_start;
	}

	public void setConnectInfo_start(String connectInfo_start) {
		this.connectInfo_start = connectInfo_start;
	}

	public String getConnectInfo_stop() {
		return this.connectInfo_stop;
	}

	public void setConnectInfo_stop(String connectInfo_stop) {
		this.connectInfo_stop = connectInfo_stop;
	}

	public String getFramedIPAddress() {
		return this.framedIPAddress;
	}

	public void setFramedIPAddress(String framedIPAddress) {
		this.framedIPAddress = framedIPAddress;
	}

	public String getFramedProtocol() {
		return this.framedProtocol;
	}

	public void setFramedProtocol(String framedProtocol) {
		this.framedProtocol = framedProtocol;
	}

	public String getNASIPAddress() {
		return this.NASIPAddress;
	}

	public void setNASIPAddress(String NASIPAddress) {
		this.NASIPAddress = NASIPAddress;
	}

	public String getNASPortId() {
		return this.NASPortId;
	}

	public void setNASPortId(String NASPortId) {
		this.NASPortId = NASPortId;
	}

	public String getNASPortType() {
		return this.NASPortType;
	}

	public void setNASPortType(String NASPortType) {
		this.NASPortType = NASPortType;
	}

	public String getRealm() {
		return this.realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}