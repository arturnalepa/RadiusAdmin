package anal.com.sample.repository.broker;

import anal.com.sample.model.Radcheck;
import anal.com.sample.model.Radgroupreply;

import java.util.List;

public interface IRadgroupreplyBroker {
    public abstract void saveOrUpdate(Radgroupreply person);
    public abstract List<Radgroupreply> getAllPersons();
    public abstract Radgroupreply getPersonById();
    public abstract Radgroupreply getPersonByEmail(String email);

}
