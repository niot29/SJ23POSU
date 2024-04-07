package se.sakilagui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();


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
        // TODO -- have not test
        Test_Film testFilm = new Test_Film();
        testFilm.Test_listAllFilm();
        //testFilm.Test_listAllByRating();
        //testFilm.Test_listAllByReleaseYear();
        //testFilm.Test_listAllByLanguage();
        //testFilm.Test_getFilmById();
        //testFilm.Test_getFilmByTitel();
        //testFilm.Test_createFilm();
        //testFilm.Test_deleteFilmById(int id);



        //
        // -- Test Actor
        //
        Test_Actor testActor = new Test_Actor();
        //testActor.listActors();
        //testActor.create();
        //testActor.updateActor();
        //testActor.getActorById();
        //testActor.deleteActorById();


        //
        // -- Test Store
        // TODO -- have not test
        Test_Store testStore = new Test_Store();
        //testStore.Test_getStoreById();

        //
        // -- Test City
        //
        Test_City testCity = new Test_City();
        //testCity.listCity();
        //OK testCity.getCityById();
        //OK testCity.createCity();
        //OK testCity.createCity();
        //OK testCity.updateCity();
        //Ok testCity.deleteCityById(601);


        //
        // -- Test Country
        //
        Test_Country testCountry = new Test_Country();
        //OK testCountry.getCountryById();
        //Ok testCountry.createCountry();
        //OK testCountry.updateCountry();
        //OK testCountry.deleteCountryById();
        //OK testCountry.listCountry();

        //
        // -- Test FilmActor
        // TODO -- have not test
        Test_FilmActor testFilmActor = new Test_FilmActor();
        //testFilmActor.getFilmActorById();
        //testFilmActor.getAllFilmActors();


    }



}