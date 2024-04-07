package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.CountryEntity;
import se.sakilagui.Model.StoreEntity;

import java.util.ArrayList;
import java.util.List;

public class CountryDBService implements CountryDBInterface{
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public void createCountry(CountryEntity country) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(country);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong. in Create StoreDBServices");
        }
    }

    @Override
    public CountryEntity getCountryById(int id) {
        CountryEntity country = new CountryEntity();
        try (Session session = sessionFactory.openSession()) {
            country = session.get(CountryEntity.class, id);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something went wrong. Session Connection");
        }
        return country;
    }

    @Override
    public List<CountryEntity> listCountry() {
        List<CountryEntity> countryEntityList = new ArrayList<CountryEntity>();
        try (Session session = sessionFactory.openSession()) {
            countryEntityList = session.createQuery("FROM CountryEntity", CountryEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something went wrong. Session Connection");
        }
        return countryEntityList;
    }

    @Override
    public CountryEntity updateCountry(CountryEntity country) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(country);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong. in Create StoreDBServices");
        }
        return getCountryById(country.getId());
    }

    @Override
    public void deleteCountryById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CountryEntity country = session.get(CountryEntity.class, id);
            session.delete(country);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong. in Create StoreDBServices");
        }

    }
}
