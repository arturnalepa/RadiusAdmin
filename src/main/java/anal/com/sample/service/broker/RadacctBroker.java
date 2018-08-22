package anal.com.sample.service.broker;

import anal.com.sample.model.Radacct;
import anal.com.sample.model.Radcheck;
import anal.com.sample.repository.broker.IRadacctBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
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
    public List<Radacct> getAllRadacct() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        Date now = cal.getTime();
        cal.add(Calendar.MONTH, -1);


        System.out.println(format.format(cal.getTime()));




      //  java.util.Date startDate = dateFormat.parse("yyyy-MM-dd HH:mm:ss");




        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radacct> cq = cb.createQuery(Radacct.class);
        Root<Radacct> root = cq.from(Radacct.class);
          Predicate startDatePredicate  = cb.greaterThanOrEqualTo(root.get("acctStartTime").as(java.sql.Timestamp.class), cal.getTime());
          Predicate endDatePredicate  = cb.lessThanOrEqualTo(root.get("acctStartTime").as(java.sql.Timestamp.class), now);


        Predicate and = cb.and(startDatePredicate, endDatePredicate);
        cq.where(and);
     //   cq.orderBy(cb.asc(root.get("radAcctId")));
     //   cq.distinct(true);
        TypedQuery<Radacct> query = em.createQuery(cq);
        List<Radacct> radacct = query.getResultList();
        em.getTransaction().commit();
         return radacct;
    }

    @Override
    public  List<Radacct> getRadacctToMack(String MacAddress){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Radacct> cq = cb.createQuery(Radacct.class);
        Root<Radacct> root = cq.from(Radacct.class);
          Predicate condition = cb.equal(root.get("userName"), MacAddress);
           cq.where(condition);
        //   cq.orderBy(cb.asc(root.get("radAcctId")));
        //   cq.distinct(true);
        TypedQuery<Radacct> query = em.createQuery(cq);
        List<Radacct> radacct = query.getResultList();



        return radacct;
    }
    @Override
    public  List<Radacct> getIPRadacctToMack(String MacAddress){

        CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Radacct> cq = cb.createQuery(Radacct.class);
        Root<Radacct> root = cq.from(Radacct.class);
        Predicate condition = cb.equal(root.get("userName"), MacAddress);
       cb.max(root.get("acctStartTime"));
     //   Expression maxDate = cb.max(root.get("acctStartTime"));
   // cq.select(maxDate);
        cq.where(condition);
        //   cq.orderBy(cb.asc(root.get("radAcctId")));
        //   cq.distinct(true);
        TypedQuery<Radacct> query = em.createQuery(cq);
        List<Radacct> radacct = query.getResultList();

       return radacct;
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
