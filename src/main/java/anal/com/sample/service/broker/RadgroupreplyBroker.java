package anal.com.sample.service.broker;

import anal.com.sample.model.Radgroupreply;
import anal.com.sample.repository.broker.IRadgroupreplyBroker;
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
    public List<Radgroupreply> getAllVlan() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radgroupreply> cq = cb.createQuery(Radgroupreply.class);
        Root<Radgroupreply> root = cq.from(Radgroupreply.class);
        Predicate condition = cb.equal(root.get("attribute"), "Tunnel-Private-Group-ID");
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("value")));
        cq.distinct(true);
        TypedQuery<Radgroupreply> query = em.createQuery(cq);
       List<Radgroupreply> vlan = query.getResultList();

return vlan;
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Radgroupreply getPersonById() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radgroupreply getPersonByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radgroupreply getGroupByVlan(String selvlan) {
        em.getTransaction().begin();
        Radgroupreply radgroupreply = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radgroupreply> cq = cb.createQuery(Radgroupreply.class);
        Root<Radgroupreply> root = cq.from(Radgroupreply.class);
        Predicate condition = cb.equal(root.get("value"), selvlan);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("groupName")));
        cq.distinct(true);
        TypedQuery<Radgroupreply> query = em.createQuery(cq);
        em.getTransaction().commit();
        //  radgroupreply = query.getSingleResult();
        try {
            radgroupreply = (Radgroupreply) query.getSingleResult();
      //      System.out.println("W grupie: " + radgroupreply.getGroupName());
        } catch (NoResultException nre) {
        }
        if (radgroupreply == null) {
       //     System.out.println("W grupie: " + radgroupreply);
           return null;

        } else {
            return radgroupreply;
        }

    }

    public Radgroupreply getVlanbyGroup(String gropuname) {
        em.getTransaction().begin();
        Radgroupreply radgroupreply = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radgroupreply> cq = cb.createQuery(Radgroupreply.class);
        Root<Radgroupreply> root = cq.from(Radgroupreply.class);
        Predicate condition1 = cb.equal(root.get("groupName"), gropuname);
        Predicate condition2 = cb.equal(root.get("attribute"), "Tunnel-Private-Group-ID");
        Predicate condition = cb.and (( condition1 ),( condition2 ));
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("value")));
        cq.distinct(true);
        TypedQuery<Radgroupreply> query = em.createQuery(cq);
        em.getTransaction().commit();
        //  radgroupreply = query.getSingleResult();
        try {
            radgroupreply = (Radgroupreply) query.getSingleResult();
     //       System.out.println("W Vlanie: " + radgroupreply.getValue());
        } catch (NoResultException nre) {

        }
        if (radgroupreply == null) {
         //   System.out.println("W grupie: " + radgroupreply);
            Radgroupreply rep = new Radgroupreply();
            rep.setValue("0");
            return rep ;
        } else {
            return radgroupreply;
        }

//        TypedQuery<Radgroupreply> query = em.createQuery(cq);
//        List<Radgroupreply> radgroupreply = query.getResultList();
//        for (Radgroupreply c : radgroupreply) {
//
//        //    System.out.println(c.getGroupName()+" "+c.getValue());
//        }
//        return radgroupreply;
//}
    }
}
