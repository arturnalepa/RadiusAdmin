package anal.com.sample.service.service;

import anal.com.sample.model.Radreply_old;
import anal.com.sample.repository.broker.IRadreplyBroker;
import anal.com.sample.repository.service.IRadreplyService;
import anal.com.sample.service.broker.RadreplyBroker;

import java.util.List;

public class RadreplyService implements IRadreplyService {
    private IRadreplyBroker broker;

    public RadreplyService() {
        broker = new RadreplyBroker();
    }

    @Override
    public void saveOrUpdate(Radreply_old person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Radreply_old> getAllVlan() {
        return broker.getAllVlan();
    }

//    @Override
//    public Radcheck getPersonById(int id) {
//        return broker.getPersonById(id);
//    }

    @Override
    public Radreply_old getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radreply_old testowa() {
        return null;
    }

    @Override
    public Radreply_old testowa2() {
        return null;
    }

    public Radreply_old getGroupByVlanId(int id) {
        return broker.getGroupByVlanId(id);
    }

}
