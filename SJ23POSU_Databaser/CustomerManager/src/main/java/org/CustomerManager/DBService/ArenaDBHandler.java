package org.CustomerManager.DBService;

import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Concert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ArenaDBHandler implements ArenaDBInterface {
    @Override
    public void create(Arena arena) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int id =(Integer) session.save(arena);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Arena getArenaById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Arena arena=session.get(Arena.class,id);
        session.getTransaction().commit();
        session.close();
        return arena;
    }

    @Override
    public List<Arena> ListArena() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Arena> arena = session.createQuery("FROM Arena", Arena.class).getResultList();
        return arena;
    }

    @Override
    public Arena updateArena(Arena arena) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(arena);
        session.getTransaction().commit();
        session.close();

        return arena;
    }

    @Override
    public void deleteArenaById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Arena arena = session.get(Arena.class, id);
        session.delete(arena);
        session.getTransaction().commit();
        session.close();

    }
}
