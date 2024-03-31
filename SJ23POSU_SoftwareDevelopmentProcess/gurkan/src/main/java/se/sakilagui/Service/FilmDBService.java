package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.FilmEntity;

import java.sql.Date;
import java.util.List;

public class FilmDBService implements FilmDBServiceInterface {
    @Override
    public FilmEntity createFilm(FilmEntity film) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(film);
        System.out.println(film.getId());   // get id after save
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public List<FilmEntity> listAllFilm() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmEntity> filmList = session.createQuery("FROM FilmEntity", FilmEntity.class).getResultList();
        return filmList;
    }

    @Override
    public List<FilmEntity> listAllByRating(String rateting) {
        return null;
    }

    @Override
    public List<FilmEntity> listAllByReleaseYear(Date releaseYear) {
        return null;
    }

    @Override
    public List<FilmEntity> listAllByLanguageId(int languageId) {
        return null;
    }

    @Override
    public FilmEntity getFilmById(int id) {
        return null;
    }

    @Override
    public FilmEntity getFilmByTitel(String titel) {
        return null;
    }

    @Override
    public void deleteFilmById(int id) {

    }
}
