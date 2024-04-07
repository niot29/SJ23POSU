package se.sakilagui;

import se.sakilagui.Controller.FilmController;
import se.sakilagui.Controller.FilmTextController;
import se.sakilagui.Controller.LanguageController;
import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.Service.ConvertTools;

import java.sql.Timestamp;
import java.util.List;

public class Test_Film {
    static FilmController filmController = new FilmController();
    static LanguageController languageController = new LanguageController();
    static ConvertTools convertTools = new ConvertTools();

    void Test_listAllFilm(){
        for(FilmEntity filmEntity: filmController.listAllFilm()){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void Test_listAllByRating(){
        for(FilmEntity filmEntity: filmController.listAllByRating("PG13")){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void Test_listAllByReleaseYear(){
        for(FilmEntity filmEntity: filmController.listAllByReleaseYear("2006")){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void Test_listAllByLanguage(){
        for(FilmEntity filmEntity: filmController.listAllByLanguage("English")){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void  Test_listAllByCategory(){
        for(FilmEntity filmEntity: filmController.listAllByCategory("Comedy")){
            System.out.println("FilmObject: " + filmEntity);
        }

    }

    void Test_getFilmById(){
        System.out.println("FilmObject: " + filmController.getFilmById(1));
    }

    void Test_getFilmByTitel(){
        for(FilmEntity filmEntity: filmController.getFilmByTitel("ACADEMY DINOSAUR")){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void Test_createFilm(){
        LanguageEntity language = languageController.getLanguageByName("English");
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setTitle("0002 ACADEMY DINOSAUR XXX");
        filmEntity.setDescription("TestFilm");
        filmEntity.setLanguage(language);
        System.out.println(filmEntity);
        filmController.createFilm(filmEntity);
    }

    void Test_deleteFilmById(int id){
        filmController.deleteFilmById(id);
    }



}
