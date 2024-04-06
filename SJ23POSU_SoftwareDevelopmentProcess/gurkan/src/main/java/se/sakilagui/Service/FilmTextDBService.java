package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.FilmTextEntity;

import java.util.List;

public class FilmTextDBService implements FilmTextDBServiceInterface{
    @Override
    public FilmTextEntity createFilmText(FilmTextEntity filmTextEntity) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(filmTextEntity);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public List<FilmTextEntity> listAllFilmText() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmTextEntity> filmTextEntityList = session.createQuery("FROM FilmTextEntity", FilmTextEntity.class).getResultList();
        return filmTextEntityList;
    }

    @Override
    public List<FilmTextEntity> listAllByDesc(String text) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmTextEntity> filmTextEntityList = session.createQuery("FROM FilmTextEntity ft WHERE ft.description like :searchText", FilmTextEntity.class)
                .setParameter("searchText", "%" + text + "%")
                .getResultList();

        session.close();
        return filmTextEntityList;
    }

    @Override
    public FilmTextEntity getFilmTextById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FilmTextEntity filmTextEntity = new FilmTextEntity();
        try {
            filmTextEntity = session.get(FilmTextEntity.class, id);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);

        }

        session.close();
        return filmTextEntity;
    }

    @Override
    public List<FilmTextEntity> getFilmByTitel(String titel) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmTextEntity> filmTextEntityList = session.createQuery("FROM FilmTextEntity ft WHERE ft.title like :searchTitle", FilmTextEntity.class)
                .setParameter("searchTitle", "%" + titel + "%")
                .getResultList();

        session.close();
        return filmTextEntityList;
    }

    @Override
    public void deleteTextById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FilmTextEntity filmTextEntity = session.get(FilmTextEntity.class, id);
        session.delete(filmTextEntity);
        session.getTransaction().commit();
        session.close();

    }
}
