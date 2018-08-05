package anal.com.sample.repository.broker;

import anal.com.sample.model.Radusergroup;

import java.util.List;

public interface IRadusergroupBroker {
    public abstract void saveOrUpdate(Radusergroup person);
    public abstract List<Radusergroup> getAllPersonsInGroup(String groupname);
    public abstract Radusergroup getPersonById(int id);
    public abstract Radusergroup getPersonByEmail(String email);
    public abstract String getGroupbyVlan(String VlanGroupName);
    public abstract Radusergroup getUserNameToGroup(String username);
}
