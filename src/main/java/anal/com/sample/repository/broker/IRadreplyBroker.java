package anal.com.sample.repository.broker;

import anal.com.sample.model.Radreply_old;

import java.util.List;

public interface IRadreplyBroker {
    public abstract void saveOrUpdate(Radreply_old person);

    public abstract List<Radreply_old> getAllVlan();

    public abstract Radreply_old getGroupByVlanId(int id);

    public abstract Radreply_old getPersonByEmail(String email);

}
