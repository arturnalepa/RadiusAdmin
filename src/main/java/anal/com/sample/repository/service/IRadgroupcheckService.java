package anal.com.sample.repository.service;

import anal.com.sample.model.Radgroupcheck_old;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRadgroupcheckService {
    void saveOrUpdate(Radgroupcheck_old person);
    List<Radgroupcheck_old>  getAllVlan();
    Radgroupcheck_old getGroupByVlanId(int id);
    Radgroupcheck_old getPersonByEmail(String email);
    Radgroupcheck_old testowa();
    Radgroupcheck_old testowa2();



}
