package anal.com.sample.service.service;

import anal.com.sample.model.Radacct_old;
import anal.com.sample.repository.broker.IRadacctBroker;
import anal.com.sample.repository.service.IRadacctService;
import anal.com.sample.service.broker.RadacctBroker;

import java.util.List;

public class RadacctService implements IRadacctService {
    private IRadacctBroker broker;

    public RadacctService() {
        broker = new RadacctBroker();
    }

    @Override
    public void saveOrUpdate(Radacct_old person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Radacct_old>  getAllVlan() {
         return broker.getAllVlan();
    }

//    @Override
//    public Radcheck getPersonById(int id) {
//        return broker.getPersonById(id);
//    }

    @Override
    public Radacct_old getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radacct_old testowa() {
        return null;
    }
    @Override
    public Radacct_old testowa2() {
        return null;
    }

    public Radacct_old getGroupByVlanId(int id) {return  broker.getGroupByVlanId(id);
    }

}
