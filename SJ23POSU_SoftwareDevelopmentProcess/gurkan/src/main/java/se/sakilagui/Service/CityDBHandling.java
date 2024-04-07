package se.sakilagui.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.CityEntity;

import java.util.List;

public class CityDBHandling implements CityDBinterface{

    public void createCity(CityEntity cityEntity){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(cityEntity);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    public CityEntity getCityById(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CityEntity city = session.get(CityEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return city;
    }
    public List<CityEntity> listCity(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<CityEntity> city = session.createQuery("FROM CityEntity", CityEntity.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return city;
    }
    public CityEntity updateCity(CityEntity city){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }
    public void deleteCityById(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CityEntity city = session.get(CityEntity.class, id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
    }
}
