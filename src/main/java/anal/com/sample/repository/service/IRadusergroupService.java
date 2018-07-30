package anal.com.sample.repository.service;

import anal.com.sample.model.Radusergroup;

import java.util.List;

public interface IRadusergroupService {
    void saveOrUpdate(Radusergroup person);
    List<Radusergroup> getAllPersons();
    Radusergroup getPersonById(int id);
    Radusergroup getPersonByEmail(String email);
  Radusergroup testowa();
    Radusergroup testowa2();


}
