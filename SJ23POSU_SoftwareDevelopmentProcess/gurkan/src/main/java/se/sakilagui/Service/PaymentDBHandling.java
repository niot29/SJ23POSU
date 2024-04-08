package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.PaymentEntity;
import se.sakilagui.Service.PaymentInterface;

import java.util.List;

public class PaymentDBHandling implements PaymentInterface {
    @Override
    public void create(PaymentEntity payment) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(payment);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Override
    public PaymentEntity getPaymentById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        PaymentEntity payment = session.get(PaymentEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return payment;
    }

    @Override
    public List<PaymentEntity> getAllPayments() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<PaymentEntity> payments = session.createQuery("FROM PaymentEntity", PaymentEntity.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return payments;
    }

    @Override
    public PaymentEntity updatePayment(PaymentEntity payment) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(payment);
        session.getTransaction().commit();
        session.close();
        return payment;
    }

    @Override
    public void deletePaymentById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        PaymentEntity payment = session.get(PaymentEntity.class, id);
        session.delete(payment);
        session.getTransaction().commit();
        session.close();
    }
}
