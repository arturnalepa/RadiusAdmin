package anal.com.sample.service.service;

import anal.com.sample.model.Userinfo;
import anal.com.sample.repository.broker.IUserinfoBroker;
import anal.com.sample.repository.service.IUserinfoService;
import anal.com.sample.service.broker.UserinfoBroker;

public class UserinfoService implements IUserinfoService {
    private IUserinfoBroker broker;

    public UserinfoService() {
        broker = new UserinfoBroker();
    }

    @Override
    public void saveOrUpdate(Userinfo userinfo) {
        broker.saveOrUpdate(userinfo);
    }

    @Override
    public Userinfo findUserInfo (String colmacaddress) { return broker.findUserInfo(colmacaddress);  }
}
