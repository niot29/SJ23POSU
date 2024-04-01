package se.sakilagui.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;

import java.util.List;

public class LanguageDBServes implements LanguageDBServeInterface {
    @Override
    public LanguageEntity getLanguageByName(String langname) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        LanguageEntity language = session.createQuery("FROM LanguageEntity l WHERE l.name = :name", LanguageEntity.class)
                .setParameter("name", langname)
                .getResultList().getFirst();

        session.close();
        return language;
    }
}
