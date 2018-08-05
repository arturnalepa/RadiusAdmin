package anal.com.sample.service.broker;

import anal.com.sample.model.Nas;
import anal.com.sample.repository.broker.INasBroker;

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
public class NasBroker implements INasBroker {
    private EntityManager em;

    public NasBroker() {
        em = Persistence.createEntityManagerFactory("RadiusAdminHibernate").createEntityManager();
    }

    @Override
    public void saveOrUpdate(Nas nas) {
        em.getTransaction().begin();
        em.merge(nas);
        em.getTransaction().commit();
    }

    @Override
    public List<Nas> getAllNas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Nas> cq = cb.createQuery(Nas.class);
        Root<Nas> root = cq.from(Nas.class);
      //  Predicate condition = cb.equal(root.get("Attribute"), "Tunnel-Private-Group-ID");
      //  cq.where(condition);
        cq.orderBy(cb.asc(root.get("nasname")));
    //    cq.distinct(true);
        TypedQuery<Nas> query = em.createQuery(cq);
        List<Nas> nas = query.getResultList();

//        for (Nas c : nas) {
//
//            System.out.println(c.getNasname());
//
//        }

      return nas;
}

    @Override
    public Nas getNasByNasname(String nasName) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Nas> cq = cb.createQuery(Nas.class);
        Root<Nas> root = cq.from(Nas.class);
        Predicate condition = cb.equal(root.get("nasname"), nasName);
        cq.where(condition);
        cq.orderBy(cb.asc(root.get("nasname")));
        cq.distinct(true);
        TypedQuery<Nas> query = em.createQuery(cq);
        Nas nas = query.getSingleResult();

return nas;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
