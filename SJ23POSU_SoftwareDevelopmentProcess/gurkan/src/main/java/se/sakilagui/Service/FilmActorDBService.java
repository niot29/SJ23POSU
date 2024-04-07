package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.FilmActorEntity;

import java.util.Collections;
import java.util.List;

public class FilmActorDBService implements FilmActorInterface{
    private final SessionFactory sessionFactory;
    public FilmActorDBService() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }



    @Override
    public void createFilmActor(FilmActorEntity filmActor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(filmActor);
            transaction.commit();
        }
    }
    @Override
    public List<FilmActorEntity> getFilmActorById(FilmActorEntity id) {
        List<FilmActorEntity> filmActorsList = null;
        try (Session session = sessionFactory.openSession()) {
            filmActorsList = Collections.singletonList(session.get(FilmActorEntity.class, id));
        }
        return filmActorsList;
    }
    @Override
    public List<FilmActorEntity> getAllFilmActors() {
        List<FilmActorEntity> filmActors = null;
        try (Session session = sessionFactory.openSession()) {
            filmActors = session.createQuery("FROM FilmActorEntity", FilmActorEntity.class).getResultList();
        }
        return filmActors;
    }
    @Override
    public FilmActorEntity updateFilmActor(FilmActorEntity filmActor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(filmActor);
            transaction.commit();
        }
        return filmActor;
    }
    @Override
    public void deleteFilmActorById(FilmActorEntity id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            FilmActorEntity filmActor = session.get(FilmActorEntity.class, id);
            session.delete(filmActor);
            transaction.commit();
        }
    }

}
