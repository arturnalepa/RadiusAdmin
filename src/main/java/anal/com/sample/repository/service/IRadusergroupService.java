package anal.com.sample.repository.service;

import anal.com.sample.model.Radusergroup;

import java.util.List;

public interface IRadusergroupService {
    void saveOrUpdate(Radusergroup person);
    List<Radusergroup> getAllPersonsInGroup(String groupname);
    Radusergroup getPersonById(int id);
    Radusergroup getPersonByEmail(String email);
  Radusergroup testowa();
    Radusergroup testowa2();


    String getGroupbyVlan(String  VlanGroupName);

    Radusergroup getUserNameToGroup(String username);
}
