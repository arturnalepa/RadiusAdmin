package anal.com.sample.repository.service;

import anal.com.sample.model.Userbillinfo;

public interface IUserbillinfoService {
    void saveOrUpdate(Userbillinfo userinfo);

    Userbillinfo findUserInfo(String colmacaddress);

}
