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
        for(FilmEntity filmEntity: filmController.listAllByRating("G")){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void Test_listAllByReleaseYear(){
        for(FilmEntity filmEntity: filmController.listAllByReleaseYear("2006")){
            System.out.println("FilmObject: " + filmEntity);
        }
    }

    void Test_listAllByLanguage(){
        for(FilmEntity filmEntity: filmController.listAllByLanguage("German")){
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
        LanguageEntity language = languageController.getLanguageByName("German");
        FilmEntity entity = new FilmEntity();
        entity.setTitle("0002 ACADEMY DINOSAUR XXX");
        entity.setDescription("TestFilm");
        entity.setLanguage(language);
        entity.setLastUpdate(convertTools.getlastUpdate());
        filmController.createFilm(entity);
    }

    void Test_deleteFilmById(int id){

    }



}
