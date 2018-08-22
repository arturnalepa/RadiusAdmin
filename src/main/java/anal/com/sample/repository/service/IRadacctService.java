package anal.com.sample.repository.service;

import anal.com.sample.model.Radacct;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
public interface IRadacctService {
    void saveOrUpdate(Radacct person);

    List<Radacct> getAllRadacct() throws ParseException;

    Radacct getGroupByVlanId(int id);

    Radacct getPersonByEmail(String email);

    Radacct testowa();

    Radacct testowa2();


    List<Radacct> getRadacctToMack(String toString);

    List<Radacct> getIPRadacctToMack(String toString);
}
