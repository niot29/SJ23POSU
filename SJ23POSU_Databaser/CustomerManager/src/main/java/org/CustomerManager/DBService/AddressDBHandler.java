package org.CustomerManager.DBService;

import org.CustomerManager.Model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class AddressDBHandler implements AddressDBInterface{
    @Override
    public void create(Address address) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
        session.close();
        System.out.println("Address saved successfully!");
    }
    @Override
    public Address getAddressById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address=session.get(Address.class,id);
        session.getTransaction().commit();
        session.close();
        return address;
    }
    @Override
    public List<Address> ListAddress() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Address> addresses = session.createQuery("FROM Address", Address.class).getResultList();
        return addresses;
    }
    @Override
    public Address updateAddress(Address address) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(address);
        session.persist(address);
        session.getTransaction().commit();
        session.close();
        System.out.println("Address saved successfully!");
        return address;
    }
    @Override
    public void deleteAddressByCustomerId(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CustomerDBHandler customrtControl=new CustomerDBHandler();
        int customerId=customrtControl.getCustomerIdByAddressId(id);
        customrtControl.deleteCustomerById(customerId);
        Address address = session.get(Address.class, id);
        session.delete(address);
        session.getTransaction().commit();
        System.out.println("Address deleted successfully!");
        System.out.println("Address not found for ID: " + id);
        session.getTransaction().rollback();
        session.close();
    }
    public void deleteAddressByArenaId(int id) {
        /*
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ArenaDBHandler arenaDBHandler =new ArenaDBHandler();
        int arenaId=arenaDBHandler.getArenaIdByAddressId(id);
        arenaDBHandler.deleteArenaById(arenaId);
        Address address = session.get(Address.class, id);
        session.delete(address);
        session.getTransaction().commit();
        session.close();

         */
    }
}
