package anal.com.sample.service.service;

import anal.com.sample.model.Radpostauth_log;
import anal.com.sample.repository.broker.IRadpostauthBroker;
import anal.com.sample.repository.service.IRadpostauthService;
import anal.com.sample.service.broker.RadpostauthBroker;

public class RadpostauthService implements IRadpostauthService {
    private IRadpostauthBroker broker;

    public RadpostauthService() {
        broker = new RadpostauthBroker();
    }

    @Override
    public void saveOrUpdate(Radpostauth_log person) {
        broker.saveOrUpdate(person);
    }

//    @Override
//    public List<Radpostauth_log> getAllPersons() {
//        return broker.getAllPersons();
//    }

//    @Override
//    public Radpostauth_log getPersonById() {
//        return broker.getPersonById();
//    }

    @Override
    public Radpostauth_log getPersonByEmail(String email) {
        return null;
    }

    @Override
    public Radpostauth_log testowa() {
        return null;
    }
    @Override
    public Radpostauth_log testowa2() {
        return null;
    }
}
