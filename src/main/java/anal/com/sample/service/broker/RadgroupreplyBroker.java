package anal.com.sample.service.broker;

import anal.com.sample.model.Radgroupreply;
import anal.com.sample.repository.broker.IRadgroupreplyBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
@Repository
@Transactional
public class RadgroupreplyBroker implements IRadgroupreplyBroker {
    private EntityManager em;

    public RadgroupreplyBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }



    @Override
    public void saveOrUpdate(Radgroupreply person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public List<Radgroupreply> getAllPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radgroupreply getPersonById() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radgroupreply getPersonByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
