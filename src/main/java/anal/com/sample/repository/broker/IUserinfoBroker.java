package anal.com.sample.repository.broker;

import anal.com.sample.model.Userinfo;

public interface IUserinfoBroker {
    public abstract void saveOrUpdate(Userinfo userinfo);
    public abstract Userinfo findUserInfo(String colmacaddress);
}
