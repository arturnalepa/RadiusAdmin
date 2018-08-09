package anal.com.sample.repository.service;

import anal.com.sample.model.Radgroupreply;

import java.util.List;

public interface IRadgroupreplyService {
    void saveOrUpdate(Radgroupreply person);

    List<Radgroupreply> getAllPersons();

    Radgroupreply getPersonById();

    Radgroupreply getPersonByEmail(String email);

    Radgroupreply testowa();

    Radgroupreply testowa2();

    Radgroupreply getGroupByVlan(String selvlan);

    Radgroupreply getVlanbyGroup(String groupName);

    List<Radgroupreply> getAllVlan();
}
