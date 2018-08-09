package anal.com.sample.service.service;

import anal.com.sample.model.Radgroupcheck_old;
import anal.com.sample.repository.broker.IRadgroupcheckBroker;
import anal.com.sample.repository.service.IRadgroupcheckService;
import anal.com.sample.service.broker.RadgroupcheckBroker;

import java.util.List;

public class RadgroupcheckService implements IRadgroupcheckService {
    private IRadgroupcheckBroker broker;

    public RadgroupcheckService() {
        broker = new RadgroupcheckBroker();
    }

    @Override
    public void saveOrUpdate(Radgroupcheck_old person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Radgroupcheck_old> getAllVlan() {
        return null;
    }

//    @Override
//    public Radcheck getPersonById(int id) {
//        return broker.getPersonById(id);
//    }

    @Override
    public Radgroupcheck_old getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radgroupcheck_old testowa() {
        return null;
    }

    @Override
    public Radgroupcheck_old testowa2() {
        return null;
    }

    public Radgroupcheck_old getGroupByVlanId(int id) {
        return broker.getGroupByVlanId(id);
    }

}
