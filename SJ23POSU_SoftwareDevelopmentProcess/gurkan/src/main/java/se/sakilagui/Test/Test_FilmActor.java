package se.sakilagui.Test;

import se.sakilagui.Controller.ActorController;
import se.sakilagui.Controller.FilmActorController;
import se.sakilagui.Model.ActorEntity;
import se.sakilagui.Model.CityEntity;
import se.sakilagui.Model.FilmActorEntity;

import java.util.List;

public class Test_FilmActor {

    public void createFilmActor(FilmActorEntity filmActor){
        ActorController actorController = new ActorController();
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setFirst_name("Kung");
        actorEntity.setLast_name("Kalle");

    }
    public void getFilmActorById(){
        System.out.println(new FilmActorController().getFilmActorById(1));
    }
    public void getAllFilmActors(){
        FilmActorController filmActorController = new FilmActorController();
        System.out.println(filmActorController.getAllFilmActors());
    }
    public void updateFilmActor(FilmActorEntity filmActor){

    }
    public void deleteFilmActorById(FilmActorEntity id){

    }
}
