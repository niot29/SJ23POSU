package se.sakilagui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import se.sakilagui.Controller.FilmController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        FilmController filmController = new FilmController();
        System.out.println(filmController.listAllFilm());

    }
}