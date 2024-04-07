package se.sakilagui;

import se.sakilagui.Controller.ActorController;
import se.sakilagui.Controller.FilmActorController;
import se.sakilagui.Model.ActorEntity;
import se.sakilagui.Model.CityEntity;
import se.sakilagui.Model.FilmActorEntity;

import java.util.List;

public class Test_FilmActor {

    void createFilmActor(FilmActorEntity filmActor){
        ActorController actorController = new ActorController();
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setFirst_name("Kung");
        actorEntity.setLast_name("Kalle");

    }
    void getFilmActorById(){

    }
    void getAllFilmActors(){
        FilmActorController filmActorController = new FilmActorController();
        System.out.println(filmActorController.getAllFilmActors());
    }
    void updateFilmActor(FilmActorEntity filmActor){

    }
    void deleteFilmActorById(FilmActorEntity id){

    }
}
