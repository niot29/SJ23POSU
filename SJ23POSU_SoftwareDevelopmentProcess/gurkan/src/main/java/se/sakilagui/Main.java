package se.sakilagui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Controller.FilmController;
import se.sakilagui.Controller.FilmTextController;
import se.sakilagui.Controller.LanguageController;
import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.FilmTextEntity;
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


        //
        // -- Test FilmText
        //
        Test_FilmText testFilmText = new Test_FilmText();
        //testFilmText.Test_FilmText_listAllFilmText();
        //testFilmText.Test_FilmText_listAllByDesc();
        //testFilmText.Test_FilmText_getFilmByTitel();
        //testFilmText.Test_FilmText_getFilmById();
        //testFilmText.Test_FilmText_createFilmTextAndDeleteBYID();


        //
        // -- Test Film
        //



    }
}