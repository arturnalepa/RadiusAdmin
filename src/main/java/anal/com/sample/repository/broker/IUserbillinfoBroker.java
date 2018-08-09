package anal.com.sample.repository.broker;

import anal.com.sample.model.Userbillinfo;
import anal.com.sample.model.Userinfo;

public interface IUserbillinfoBroker {
    public abstract void saveOrUpdate(Userbillinfo userinfo);
    public abstract Userbillinfo findUserInfo(String colmacaddress);
}
