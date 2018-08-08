package anal.com.sample.repository.service;

import anal.com.sample.model.Userinfo;

public interface IUserinfoService {
    void saveOrUpdate(Userinfo userinfo);

    Userinfo findUserInfo(String colmacaddress);

}
