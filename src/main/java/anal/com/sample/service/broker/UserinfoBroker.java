package anal.com.sample.service.broker;

import anal.com.sample.model.Userinfo;
import anal.com.sample.repository.broker.IUserinfoBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public Userinfo findUserInfo(String colmacaddress) {
        em.getTransaction().begin();
        Userinfo userinfo = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Userinfo> cq = cb.createQuery(Userinfo.class);
        Root<Userinfo> root = cq.from(Userinfo.class);
        Predicate condition = cb.equal(root.get("username"), colmacaddress);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("username")));
        cq.distinct(true);
        TypedQuery<Userinfo> query = em.createQuery(cq);
        em.getTransaction().commit();

        try {
            userinfo = query.getSingleResult();
            //      System.out.println("W grupie: " + radgroupreply.getGroupName());
        } catch (NoResultException nre) {
            userinfo.setFirstname("");
        }
        if (userinfo == null) {
            //     System.out.println("W grupie: " + radgroupreply);
            userinfo.setFirstname("a");
            return userinfo;
        } else {
            return userinfo;
        }

    }
}
