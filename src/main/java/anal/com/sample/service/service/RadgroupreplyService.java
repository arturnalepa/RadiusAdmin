package anal.com.sample.service.service;

import anal.com.sample.model.Radgroupreply;
import anal.com.sample.repository.broker.IRadgroupreplyBroker;
import anal.com.sample.repository.service.IRadgroupreplyService;
import anal.com.sample.service.broker.RadgroupreplyBroker;

import java.util.List;

public class RadgroupreplyService implements IRadgroupreplyService {
    private IRadgroupreplyBroker broker;

    public RadgroupreplyService() {
        broker = new RadgroupreplyBroker();
    }

    @Override
    public void saveOrUpdate(Radgroupreply person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Radgroupreply> getAllPersons() {
        return broker.getAllPersons();
    }
    @Override
    public List<Radgroupreply> getAllVlan() {
        return broker.getAllVlan();
    }
    @Override
    public Radgroupreply getPersonById() {
        return broker.getPersonById();
    }

    @Override
    public Radgroupreply getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radgroupreply testowa() {
        return null;
    }
    @Override
    public Radgroupreply testowa2() {
        return null;
    }
    @Override
     public Radgroupreply getGroupByVlan(String selvlan) {
       return broker.getGroupByVlan(selvlan);
    }
    @Override
    public Radgroupreply getVlanbyGroup(String gropuname) {return broker.getVlanbyGroup(gropuname);
    }
}
