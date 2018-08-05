package anal.com.sample.repository.service;

import anal.com.sample.model.Radcheck;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRadcheckService {
    void saveOrUpdate(Radcheck person);
    List<Radcheck> getAllHost();
    Radcheck getGroupByVlanId(int id);
    Radcheck getPersonByEmail(String email);
    Radcheck testowa();
    Radcheck testowa2();



}
