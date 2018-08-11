package anal.com.sample.repository.broker;

import anal.com.sample.model.Radacct;

import java.util.List;

public interface IRadacctBroker {
    public abstract void saveOrUpdate(Radacct person);

    public abstract List<Radacct> getAllRadacct();

    public abstract Radacct getGroupByVlanId(int id);

    public abstract Radacct getPersonByEmail(String email);

   public abstract List<Radacct> getRadacctToMack(String macAddress);
}
