package anal.com.sample.service.service;

import anal.com.sample.model.Userbillinfo;
import anal.com.sample.model.Userinfo;
import anal.com.sample.repository.broker.IUserbillinfoBroker;
import anal.com.sample.repository.broker.IUserinfoBroker;
import anal.com.sample.repository.service.IUserbillinfoService;
import anal.com.sample.repository.service.IUserinfoService;
import anal.com.sample.service.broker.UserbillinfoBroker;
import anal.com.sample.service.broker.UserinfoBroker;

public class UserbillinfoService implements IUserbillinfoService {
    private IUserbillinfoBroker broker;

    public UserbillinfoService() {
        broker = new UserbillinfoBroker();
    }

    @Override
    public void saveOrUpdate(Userbillinfo userinfo) {
        broker.saveOrUpdate(userinfo);
    }

    @Override
    public Userbillinfo findUserInfo (String colmacaddress) { return broker.findUserInfo(colmacaddress);  }
}
