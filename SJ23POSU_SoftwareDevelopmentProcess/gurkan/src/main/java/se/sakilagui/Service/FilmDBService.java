package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.CategoryEntity;
import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.Model.RatingEnum;

import java.sql.Date;
import java.util.List;

public class FilmDBService implements FilmDBServiceInterface {
    @Override
    public FilmEntity createFilm(FilmEntity film) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(film);
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
    public List<FilmEntity> listAllByRating(String rating) {
        RatingEnum ratingEnum = RatingEnum.valueOf(rating);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmEntity> filmEntitiesList = session.createQuery("FROM FilmEntity f WHERE f.rating = :filmrating", FilmEntity.class)  //rating
                .setParameter("filmrating", ratingEnum)
                .getResultList();

        session.close();
        return filmEntitiesList;
    }

    @Override
    public List<FilmEntity>listAllByReleaseYear(Date releaseYear) {
        System.out.println(releaseYear);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmEntity> filmEntitiesList = session.createQuery("FROM FilmEntity f WHERE f.releaseYear = :release", FilmEntity.class)  //releaseYear
                .setParameter("release", releaseYear)
                .getResultList();

        session.close();
        return filmEntitiesList;
    }

    @Override
    public List<FilmEntity>listAllByLanguage(LanguageEntity language) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // select * from film f where f.language_id = 6;
        List<FilmEntity>filmEntitiesList = session.createQuery("FROM FilmEntity f WHERE f.language.language_id = :id", FilmEntity.class)
                .setParameter("id", language.getLanguage_id())
                .getResultList();

        session.close();
        return filmEntitiesList;
    }

    @Override
    public List<FilmEntity> listAllByCategory(String category) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<FilmEntity> filmEntitiesList = session.createQuery("FROM FilmEntity f INNER JOIN FilmCategoryEntity  fc ON f.filmId = fc.film.filmId" +
                        " INNER JOIN CategoryEntity c on fc.category.id = c.id where c.name like :filmcategory", FilmEntity.class)  //rating
                .setParameter("filmcategory", category)
                .getResultList();

        session.close();
        return filmEntitiesList;
    }

    @Override
    public FilmEntity getFilmById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FilmEntity filmEntity = new FilmEntity();
        try {
            filmEntity = session.get(FilmEntity.class, id);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);

        }

        session.close();
        return filmEntity;
    }

    @Override
    public List<FilmEntity>getFilmByTitel(String titel) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<FilmEntity> filmEntitiesList = session.createQuery("FROM FilmEntity f WHERE f.title like :titel", FilmEntity.class)
                .setParameter("titel", "%" + titel + "%")
                .getResultList();

        session.close();
        return filmEntitiesList;
    }

    @Override
    public void deleteFilmById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FilmEntity filmEntity = session.get(FilmEntity.class, id);
        session.delete(filmEntity);
        session.getTransaction().commit();
        session.close();
    }
}
