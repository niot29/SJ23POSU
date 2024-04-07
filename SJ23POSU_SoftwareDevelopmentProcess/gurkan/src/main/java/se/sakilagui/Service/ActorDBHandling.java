package se.sakilagui.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.ActorEntity;

import java.util.List;

public class ActorDBHandling implements ActorDBInterface {
        public void create(ActorEntity actor) {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(actor);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }
        public ActorEntity getActorById(int id) {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            ActorEntity actor = session.get(ActorEntity.class, id);
            session.close();
            return actor;
        }

        public List<ActorEntity> listActors() {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<ActorEntity> actors = session.createQuery("FROM ActorEntity", ActorEntity.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return actors;
        }

        public ActorEntity updateActor(ActorEntity actor) {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(actor);
            session.getTransaction().commit();
            session.close();
            return actor;
        }

        public void deleteActorById(int id) {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            ActorEntity actor = session.get(ActorEntity.class, id);
            session.delete(actor);
            session.getTransaction().commit();
            session.close();
        }
    }