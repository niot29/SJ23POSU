package org.CustomerManager.dbService;


import org.CustomerManager.Model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;

public class CunstomerDBCrud {
    public void getAllCutomer(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();



    }
}
