package anal.com.sample.service.service;

import anal.com.sample.model.Radusergroup;
import anal.com.sample.repository.broker.IRadusergroupBroker;
import anal.com.sample.repository.service.IRadusergroupService;
import anal.com.sample.service.broker.RadusergroupBroker;

import java.util.List;

public class RadusergroupService implements IRadusergroupService {
    private IRadusergroupBroker broker;

    public RadusergroupService() {
        broker = new RadusergroupBroker();
    }

    @Override
    public void saveOrUpdate(Radusergroup person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Radusergroup> getAllPersons() {
        return broker.getAllPersons();
    }

    @Override
    public Radusergroup getPersonById(int id) {
        return broker.getPersonById(id);
    }

    @Override
    public Radusergroup getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radusergroup testowa() {
        return null;
    }
    @Override
    public Radusergroup testowa2() {
        return null;
    }
}
