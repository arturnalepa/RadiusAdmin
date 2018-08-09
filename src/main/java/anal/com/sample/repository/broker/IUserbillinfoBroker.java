package anal.com.sample.repository.broker;

import anal.com.sample.model.Userbillinfo;

public interface IUserbillinfoBroker {
    public abstract void saveOrUpdate(Userbillinfo userinfo);

    public abstract Userbillinfo findUserInfo(String colmacaddress);
}
