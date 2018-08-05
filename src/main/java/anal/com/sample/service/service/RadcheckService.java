package anal.com.sample.service.service;

import anal.com.sample.model.Radcheck;
import anal.com.sample.repository.broker.IRadcheckBroker;
import anal.com.sample.repository.service.IRadcheckService;
import anal.com.sample.service.broker.RadcheckBroker;

import java.util.List;

public class RadcheckService implements IRadcheckService {
    private IRadcheckBroker broker;

    public RadcheckService() {
        broker = new RadcheckBroker();
    }

    @Override
    public void saveOrUpdate(Radcheck person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Radcheck> getAllHost() {
         return broker.getAllHost();
    }

//    @Override
//    public Radcheck getPersonById(int id) {
//        return broker.getPersonById(id);
//    }

    @Override
    public Radcheck getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radcheck testowa() {
        return null;
    }
    @Override
    public Radcheck testowa2() {
        return null;
    }

    public Radcheck getGroupByVlanId(int id) {return  broker.getGroupByVlanId(id);
    }

}
