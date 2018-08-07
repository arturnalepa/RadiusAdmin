package anal.com.sample.service.broker;

import anal.com.sample.model.Radusergroup;
import anal.com.sample.model.Userinfo;
import anal.com.sample.repository.broker.IUserinfoBroker;
import anal.com.sample.repository.service.IUserinfoService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
@Repository
@Transactional
public class UserinfoBroker implements IUserinfoBroker {
    private EntityManager em;

    public UserinfoBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }



    @Override
    public void saveOrUpdate(Userinfo userinfo) {
        em.getTransaction().begin();
        em.merge(userinfo);
        em.getTransaction().commit();
    }
}
