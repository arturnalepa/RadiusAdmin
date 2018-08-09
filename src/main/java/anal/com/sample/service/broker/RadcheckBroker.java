package anal.com.sample.service.broker;

import anal.com.sample.model.Radcheck;
import anal.com.sample.repository.broker.IRadcheckBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class RadcheckBroker implements IRadcheckBroker {
    private EntityManager em;

    public RadcheckBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }


    @Override
    public void saveOrUpdate(Radcheck person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public List<Radcheck> getAllHost() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radcheck> cq = cb.createQuery(Radcheck.class);
        Root<Radcheck> root = cq.from(Radcheck.class);
        Predicate condition = cb.equal(root.get("Attribute"), "User-Password");
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("Password")));
        cq.distinct(true);
        TypedQuery<Radcheck> query = em.createQuery(cq);
        List<Radcheck> radcheck = query.getResultList();


//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Radcheck> cq = cb.createQuery(Radcheck.class);
//        Root<Radcheck> root = cq.from(Radcheck.class);
//        Predicate condition = cb.equal(root.get("Attribute"), "Tunnel-Private-Group-ID");
//        cq.where(condition);
//        cq.orderBy(cb.asc(root.get("Password")));
//        cq.distinct(true);
//        TypedQuery<Radcheck> query = em.createQuery(cq);
//       List<Radcheck> radcheck = query.getResultList();
        return radcheck;
    }

    @Override
    public Radcheck getGroupByVlanId(int id) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radcheck> cq = cb.createQuery(Radcheck.class);
        Root<Radcheck> root = cq.from(Radcheck.class);
        Predicate condition = cb.equal(root.get("Vlan"), id);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("userName")));
        //   cq.distinct(true);
        TypedQuery<Radcheck> query = em.createQuery(cq);
        Radcheck radcheck = query.getSingleResult();
        System.out.println("Wyszukany MAc address: " + radcheck.getMacAddress());
        return radcheck;
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radcheck getPersonByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
