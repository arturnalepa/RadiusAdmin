package anal.com.sample.service.broker;

import anal.com.sample.model.Radpostauth_log;
import anal.com.sample.repository.broker.IRadpostauthBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Repository
@Transactional
public class RadpostauthBroker implements IRadpostauthBroker {
    private EntityManager em;

    public RadpostauthBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }


    @Override
    public void saveOrUpdate(Radpostauth_log person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

//    @Override
//    public List<Radpostauth_log> getAllVlan() {
////        CriteriaBuilder cb = em.getCriteriaBuilder();
////        CriteriaQuery<Radcheck> cq = cb.createQuery(Nas.class);
////        Root<Nas> root = cq.from(Nas.class);
////        Predicate condition = cb.equal(root.get("Attribute"), "Tunnel-Private-Group-ID");
////        cq.where(condition);
////        cq.orderBy(cb.asc(root.get("Vlan")));
////        cq.distinct(true);
////        TypedQuery<Nas> query = em.createQuery(cq);
////       List<Nas> nas = query.getResultList();
//      return null;
//}

//    @Override
//    public Radpostauth_log getGroupByVlanId(int id) {
//
////        CriteriaBuilder cb = em.getCriteriaBuilder();
////        CriteriaQuery<Radcheck> cq = cb.createQuery(Radcheck.class);
////        Root<Radcheck> root = cq.from(Radcheck.class);
////        Predicate condition = cb.equal(root.get("Value"), id);
////        cq.where(condition);
////        cq.orderBy(cb.asc(root.get("UserName")));
////        cq.distinct(true);
////        TypedQuery<Radcheck> query = em.createQuery(cq);
////        List<Radcheck> radcheck = query.getResultList();
//
//return null;
//      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Radpostauth_log getPersonByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
