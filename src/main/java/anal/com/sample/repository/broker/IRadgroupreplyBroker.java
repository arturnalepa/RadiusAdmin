package anal.com.sample.repository.broker;

import anal.com.sample.model.Radgroupreply;

import java.util.List;

public interface IRadgroupreplyBroker {
    public abstract void saveOrUpdate(Radgroupreply person);
    public abstract List<Radgroupreply> getAllPersons();
    public abstract Radgroupreply getPersonById();
    public abstract Radgroupreply getPersonByEmail(String email);

    public abstract Radgroupreply getGroupByVlan(String selvlan);

    public abstract Radgroupreply getVlanbyGroup(String gropuname);

    public abstract List<Radgroupreply> getAllVlan();
}

