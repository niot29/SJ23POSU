package se.sakilagui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Controller.FilmController;
import se.sakilagui.Controller.LanguageController;
import se.sakilagui.Model.FilmEntity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        LanguageController languageController = new LanguageController();
        FilmController filmController = new FilmController();
        //System.out.println(filmController.listAllFilm());
        //System.out.println("FilmObbejt: " + filmController.getFilmById(1));
        //System.out.println("LanFromFilmObbejt: " + filmController.getFilmById(1).getLanguage());
        //System.out.println("GetLanguageByName : " + languageController.getLanguageByName("German"));

        //for(FilmEntity filmEntity: filmController.listAllByRating("G")){
        for(FilmEntity filmEntity: filmController.listAllByLanguage("German")){
            System.out.println("FilmObbejtList: " + filmEntity);

        }

    }
}