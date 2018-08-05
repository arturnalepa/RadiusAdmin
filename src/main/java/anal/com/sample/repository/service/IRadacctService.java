package anal.com.sample.repository.service;

import anal.com.sample.model.Radacct_old;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRadacctService {
    void saveOrUpdate(Radacct_old person);
    List<Radacct_old>  getAllVlan();
    Radacct_old getGroupByVlanId(int id);
    Radacct_old getPersonByEmail(String email);
    Radacct_old testowa();
    Radacct_old testowa2();



}
