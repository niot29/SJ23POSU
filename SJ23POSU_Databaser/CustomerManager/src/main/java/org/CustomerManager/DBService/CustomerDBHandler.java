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
        // Open session to DB
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(customer);
        transaction.commit();

    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Customer> ListCustomer() {

        // test data
        Address address = new Address(50,"Stockholm",23,"12344","killervägen1");
        Customer customer1 = new Customer(100,"Nils","Ottosson","750329","123456789",address);
        Customer customer2 = new Customer(200,"Nisse","Ottosson","750329","123456789");

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);
        customerList.add(customer2);

        return customerList;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomerById(int id) {

    }
}
