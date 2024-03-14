package org.CustomerManager.DBService;

import org.CustomerManager.Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDBHandler implements  CustomerDBInterface{


    @Override
    public int create(Customer customer) {
        // Open session to DB
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(customer);
        transaction.commit();

        return 0;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Customer> ListCustomer() {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomerById(int id) {

    }
}
