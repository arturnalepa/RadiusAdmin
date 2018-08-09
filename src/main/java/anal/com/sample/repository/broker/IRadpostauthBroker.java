package anal.com.sample.repository.broker;

import anal.com.sample.model.Radpostauth_log;

public interface IRadpostauthBroker {
    public abstract void saveOrUpdate(Radpostauth_log person);

    // public abstract List<Radpostauth_log> getAllVlan();
    //   public abstract Radpostauth_log getGroupByVlanId(int id);
    public abstract Radpostauth_log getPersonByEmail(String email);

}
