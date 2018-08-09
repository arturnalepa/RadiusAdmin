package anal.com.sample.repository.broker;

import anal.com.sample.model.Radcheck;

import java.util.List;

public interface IRadcheckBroker {
    public abstract void saveOrUpdate(Radcheck person);

    public abstract List<Radcheck> getAllHost();

    public abstract Radcheck getGroupByVlanId(int id);

    public abstract Radcheck getPersonByEmail(String email);


}
