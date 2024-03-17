package org.CustomerManager.DBService;

import org.CustomerManager.Model.Concert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConcertDBHandler implements ConsertDBInterface{

    @Override
    public void create(Concert concert) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.persist(concert);
        session.getTransaction().commit();
        session.close();



    }

    @Override
    public Concert getConcertById(int id) {
        return null;
    }

    @Override
    public List<Concert> ListConcert() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Concert> concert = session.createQuery("FROM Concert", Concert.class).getResultList();
        return concert;
    }

    @Override
    public Concert updateConcert(Concert concert) {
        return null;
    }

    @Override
    public void deleteConcertById(int id) {

    }
}
