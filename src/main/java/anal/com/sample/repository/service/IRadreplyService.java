package anal.com.sample.repository.service;

import anal.com.sample.model.Radreply_old;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRadreplyService {
    void saveOrUpdate(Radreply_old person);
    List<Radreply_old>  getAllVlan();
    Radreply_old getGroupByVlanId(int id);
    Radreply_old getPersonByEmail(String email);
    Radreply_old testowa();
    Radreply_old testowa2();



}
