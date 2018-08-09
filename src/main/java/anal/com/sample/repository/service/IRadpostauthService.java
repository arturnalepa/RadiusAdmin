package anal.com.sample.repository.service;

import anal.com.sample.model.Radpostauth_log;
import org.springframework.stereotype.Repository;

@Repository
public interface IRadpostauthService {
    void saveOrUpdate(Radpostauth_log person);

    //   List<Radpostauth_log>  getAllVlan();
    //  Radpostauth_log getGroupByVlanId(int id);
    Radpostauth_log getPersonByEmail(String email);

    Radpostauth_log testowa();

    Radpostauth_log testowa2();


}
