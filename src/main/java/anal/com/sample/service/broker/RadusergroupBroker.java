package anal.com.sample.service.broker;

import anal.com.sample.model.Radusergroup;
import anal.com.sample.repository.broker.IRadusergroupBroker;
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
public class RadusergroupBroker implements IRadusergroupBroker {
    private static final String GroupName = "brak";
    private EntityManager em;

    public RadusergroupBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }


    @Override
    public void saveOrUpdate(Radusergroup person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public List<Radusergroup> getAllPersonsInGroup(String groupname) {
        em.getTransaction().begin();
        List<Radusergroup> radusergroup = null;
        System.out.println("Wybrana Grupa :" + groupname);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radusergroup> cq = cb.createQuery(Radusergroup.class);
        Root<Radusergroup> root = cq.from(Radusergroup.class);
        cq.orderBy(cb.asc(root.get("userName")));
        Predicate condition = cb.equal(root.get("groupName"), groupname);

        TypedQuery<Radusergroup> query = em.createQuery(cq.select(root).where(condition));
        radusergroup = query.getResultList();
        em.getTransaction().commit();
        return radusergroup;
    }

    @Override
    public Radusergroup getPersonById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radusergroup getPersonByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGroupbyVlan(String VlanGroupName) {
    //    em.getTransaction().begin();
        Radusergroup radgroupreply = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radusergroup> cq = cb.createQuery(Radusergroup.class);
        Root<Radusergroup> root = cq.from(Radusergroup.class);
        Predicate condition = cb.equal(root.get("groupName"), VlanGroupName);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("groupName")));
        cq.distinct(true);
        TypedQuery<Radusergroup> query = em.createQuery(cq);
     //   em.getTransaction().commit();
        //  radgroupreply = query.getSingleResult();
        try {
            radgroupreply = (Radusergroup) query.getSingleResult();
            //      System.out.println("W grupie: " + radgroupreply.getGroupName());
        } catch (NoResultException nre) {
        }
        if (radgroupreply == null) {
            //     System.out.println("W grupie: " + radgroupreply);
            return GroupName;
        } else {
            return GroupName;
        }

    }

    @Override
    public Radusergroup getUserNameToGroup(String username) {
//        em.getTransaction().begin();
        Radusergroup radusergroup = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radusergroup> cq = cb.createQuery(Radusergroup.class);
        Root<Radusergroup> root = cq.from(Radusergroup.class);
        Predicate condition = cb.equal(root.get("userName"), username);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("userName")));
        cq.distinct(true);
        TypedQuery<Radusergroup> query = em.createQuery(cq);

        //   System.out.println("Dla : "+username);
        //  radgroupreply = query.getSingleResult();
        try {

            radusergroup = query.getSingleResult();
            //      System.out.println("W grupie: " + radgroupreply.getGroupName());
        } catch (NoResultException nre) {

       //     System.out.println(nre.getMessage());

            List<Radusergroup> radlist = query.getResultList();
            for (Radusergroup rg : radlist) {
                System.out.println("Zdublowany MACAddress: " + rg.getUserName());
            }
    //       em.getTransaction().commit();
        }
        if (radusergroup == null) {
            //     System.out.println("W grupie: " + radgroupreply);
            Radusergroup rad = new Radusergroup();
            rad.setGroupName("BrakGrupy");
            return rad;
        } else {
            return radusergroup;
        }

    }

    // }
}
