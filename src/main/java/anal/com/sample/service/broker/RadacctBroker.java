package anal.com.sample.service.broker;

import anal.com.sample.model.Radacct;
import anal.com.sample.repository.broker.IRadacctBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Repository
@Transactional
public class RadacctBroker implements IRadacctBroker {
    private EntityManager em;

    public RadacctBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }




    @Override
    public void saveOrUpdate(Radacct person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public List<Radacct> getAllVlan() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Radcheck> cq = cb.createQuery(Nas.class);
//        Root<Nas> root = cq.from(Nas.class);
//        Predicate condition = cb.equal(root.get("Attribute"), "Tunnel-Private-Group-ID");
//        cq.where(condition);
//        cq.orderBy(cb.asc(root.get("Vlan")));
//        cq.distinct(true);
//        TypedQuery<Nas> query = em.createQuery(cq);
//       List<Nas> nas = query.getResultList();
      return null;
}

    @Override
    public Radacct getGroupByVlanId(int id) {

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Radcheck> cq = cb.createQuery(Radcheck.class);
//        Root<Radcheck> root = cq.from(Radcheck.class);
//        Predicate condition = cb.equal(root.get("Value"), id);
//        cq.where(condition);
//        cq.orderBy(cb.asc(root.get("UserName")));
//        cq.distinct(true);
//        TypedQuery<Radcheck> query = em.createQuery(cq);
//        List<Radcheck> radcheck = query.getResultList();

return null;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Radacct getPersonByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
