package se.sakilagui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Controller.FilmController;
import se.sakilagui.Controller.LanguageController;
import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.Service.ConvertTools;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        LanguageController languageController = new LanguageController();
        FilmController filmController = new FilmController();
        ConvertTools convertTools = new ConvertTools();
        //System.out.println(filmController.listAllFilm());
        //System.out.println("FilmObbejt: " + filmController.getFilmById(1));
        //System.out.println("LanFromFilmObbejt: " + filmController.getFilmById(1).getLanguage());
        //System.out.println("GetLanguageByName : " + languageController.getLanguageByName("German"));

        //for(FilmEntity filmEntity: filmController.listAllByRating("G")){
        //for(FilmEntity filmEntity: filmController.listAllByLanguage("German")){
        //for(FilmEntity filmEntity: filmController.listAllByReleaseYear("2006")){
        LanguageEntity language = languageController.getLanguageByName("German");
        /*
        FilmEntity entity = new FilmEntity();
        entity.setTitle("0002 ACADEMY DINOSAUR XXX");
        entity.setDescription("TestFilm");
        entity.setLanguage(language);
        entity.setLastUpdate(Timestamp.valueOf(convertTools.getlastUpdate()));
        filmController.createFilm(entity);
        */
        // filmController.deleteFilmById(1003);

        // 'XXXX ACADEMY DINOSAUR XXX', 'A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies', 2006, 1, null, 6, 0.99, 86, 20.99, 'PG', 'Deleted Scenes,Behind the Scenes', '2006-02-15 05:03:42', 0);

        for(FilmEntity filmEntity: filmController.getFilmByTitel("ACADEMY DINOSAUR")){
            System.out.println("FilmObbejtList: " + filmEntity);
        }

    }
}