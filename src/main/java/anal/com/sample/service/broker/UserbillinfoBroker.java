package anal.com.sample.service.broker;

import anal.com.sample.model.Userbillinfo;
import anal.com.sample.model.Userinfo;
import anal.com.sample.repository.broker.IUserbillinfoBroker;
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
public class UserbillinfoBroker implements IUserbillinfoBroker {
    private EntityManager em;

    public UserbillinfoBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }



    @Override
    public void saveOrUpdate(Userbillinfo userinfo) {
        em.getTransaction().begin();
        em.merge(userinfo);
        em.getTransaction().commit();
    }
    @Override
    public Userbillinfo findUserInfo(String colmacaddress){
        em.getTransaction().begin();
        Userbillinfo userinfo=null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Userbillinfo> cq = cb.createQuery(Userbillinfo.class);
        Root<Userbillinfo> root = cq.from(Userbillinfo.class);
        Predicate condition = cb.equal(root.get("username"), colmacaddress);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("username")));
        cq.distinct(true);
        TypedQuery<Userbillinfo> query = em.createQuery(cq);
        em.getTransaction().commit();

        try {
            userinfo = query.getSingleResult();
            //      System.out.println("W grupie: " + radgroupreply.getGroupName());
        } catch (NoResultException nre) {
          //  userinfo.setFirstname("");
        }
        if (userinfo == null) {
            //     System.out.println("W grupie: " + radgroupreply);
      //      userinfo.setFirstname("a");
            return userinfo;
        } else {
            return userinfo;
        }

    }
}
