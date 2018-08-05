package anal.com.sample.repository.broker;

import anal.com.sample.model.Radacct_old;

import java.util.List;

public interface IRadacctBroker {
    public abstract void saveOrUpdate(Radacct_old person);
    public abstract List<Radacct_old> getAllVlan();
    public abstract Radacct_old getGroupByVlanId(int id);
    public abstract Radacct_old getPersonByEmail(String email);

}
