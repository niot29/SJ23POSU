package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.ActorEntity;
import se.sakilagui.Model.StoreEntity;

import java.util.ArrayList;
import java.util.List;

public class StoreDBServices implements StoreDBServicesInterface{
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public void create(StoreEntity store) {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(store);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong. in Create StoreDBServices");
        }

    }

    @Override
    public StoreEntity getStoreById(int id) {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        StoreEntity storeEntity = new StoreEntity();
        try (Session session = sessionFactory.openSession()) {
            storeEntity = session.get(StoreEntity.class, id);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something went wrong. Session Connection");
        }
        return storeEntity;
    }


    @Override
    public List<StoreEntity> listStores() {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        List<StoreEntity> storeEntityList = new ArrayList<StoreEntity>();
        try (Session session = sessionFactory.openSession()) {
            storeEntityList = session.createQuery("FROM StoreEntity", StoreEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something went wrong. Session Connection");
        }
        return storeEntityList;
    }

    @Override
    public StoreEntity updateStore(StoreEntity store) {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(store);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong. in Create StoreDBServices");
        }
        return getStoreById(store.getId());
    }

    @Override
    public void deleteStoreById(int id) {
       //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            StoreEntity storeEntity = session.get(StoreEntity.class, id);
            session.delete(storeEntity);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong. in Create StoreDBServices");
        }
    }
}
