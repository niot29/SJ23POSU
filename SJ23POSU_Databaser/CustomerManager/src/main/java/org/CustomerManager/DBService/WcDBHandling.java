package org.CustomerManager.DBService;

import org.CustomerManager.Model.Wc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class WcDBHandling implements WcDBInterface{
    @Override
    public void  create(Wc wc) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(wc);
        session.getTransaction().commit();
        session.close();
        System.out.println("Wc info saved successfully!");
    }
    @Override
    public Wc getWcById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Wc wc=session.get(Wc.class,id);
        session.getTransaction().commit();
        session.close();
        return wc;
    }
    @Override
    public List<Wc> ListWc() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Wc> wcs = session.createQuery("FROM Wc", Wc.class).getResultList();
        return wcs;
    }
    @Override
    public List<Wc> ListWcByCustomerId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the customer ID you want to list all WCs from:");
        int customerId = scanner.nextInt();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Wc> wcs = session.createQuery("SELECT c.wc FROM Customer c WHERE c.id = :customerId", Wc.class)
                .setParameter("customerId", customerId)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return wcs;
    }
    @Override
    public Wc updateCustomer(Wc wc) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(wc);
        session.getTransaction().commit();
        session.close();
        System.out.println("wc info saved successfully!");
        return wc;
    }
    @Override
    public void deleteWcById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Wc wc = session.get(Wc.class, id);
        session.delete(wc);
        session.getTransaction().commit();
        session.getTransaction().rollback();
        session.close();
    }
    public int getWcIdByConcertId(int concertId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer wcId = session.createQuery("SELECT c.wc.id FROM Concert c WHERE c.id = :concertId", Integer.class)
                .setParameter("concertId", concertId)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return wcId;
    }
    public int getWcIdByCustomerId(int customerId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer wcId = session.createQuery("SELECT c.wc.id FROM Customer c WHERE c.id = :customerId", Integer.class)
                .setParameter("concertId", customerId)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return wcId;
    }
}
