package org.CustomerManager.DBService;

import org.CustomerManager.Model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CustomerDBHandler implements  CustomerDBInterface{

    @Override
    public void create(Customer customer) {
        /*
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        */

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        System.out.println(customer);

        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public Customer getCustomerById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
        session.getTransaction().commit();
        session.close();
        return customer;
    }
    @Override
    public List<Customer> ListCustomer() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
        return customers;    }
    @Override
    public Customer updateCustomer(Customer customer) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       //session.update(customer);
        session.merge(customer);
        session.getTransaction().commit();
        session.close();

        return customer;
    }
    @Override
    public void deleteCustomerById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.getTransaction().commit();
        //session.getTransaction().rollback();
        session.close();
    }
    public int getCustomerIdByAddressId(int addressId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer customerId = session.createQuery("SELECT c.id FROM Customer c WHERE c.address.id = :addressId", Integer.class)
                .setParameter("addressId", addressId)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return customerId;
    }
}
