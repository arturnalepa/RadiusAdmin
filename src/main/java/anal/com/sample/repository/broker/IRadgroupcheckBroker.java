package anal.com.sample.repository.broker;

import anal.com.sample.model.Radgroupcheck_old;

import java.util.List;

public interface IRadgroupcheckBroker {
    public abstract void saveOrUpdate(Radgroupcheck_old person);
    public abstract List<Radgroupcheck_old> getAllVlan();
    public abstract Radgroupcheck_old getGroupByVlanId(int id);
    public abstract Radgroupcheck_old getPersonByEmail(String email);

}
