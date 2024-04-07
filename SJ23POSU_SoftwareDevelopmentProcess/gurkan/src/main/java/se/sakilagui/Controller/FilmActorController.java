package se.sakilagui.Controller;

import se.sakilagui.Model.FilmActorEntity;
import se.sakilagui.Service.ConvertTools;
import se.sakilagui.Service.FilmActorDBService;
import se.sakilagui.Service.FilmActorInterface;

import java.util.List;

public class FilmActorController implements FilmActorInterface {


    @Override
    public List<FilmActorEntity> getFilmActorById(FilmActorEntity id) {
        FilmActorDBService filmActorDBService = new FilmActorDBService();
        return filmActorDBService.getFilmActorById(id);
    }

    @Override
    public List<FilmActorEntity> getAllFilmActors() {
        FilmActorDBService filmActorDBService = new FilmActorDBService();
        return filmActorDBService.getAllFilmActors();
    }

    @Override
    public FilmActorEntity updateFilmActor(FilmActorEntity filmActor) {
        FilmActorDBService filmActorDBService = new FilmActorDBService();
        ConvertTools convertTools = new ConvertTools();
        filmActor.setLastUpdate(convertTools.getlastUpdate());
        filmActorDBService.createFilmActor(filmActor);
        return null; // TODO can vi return FilmActor ..?

    }

    @Override
    public void deleteFilmActorById(FilmActorEntity id) {
        FilmActorDBService filmActorDBService = new FilmActorDBService();
        filmActorDBService.deleteFilmActorById(id);
    }
    @Override
    public void createFilmActor(FilmActorEntity filmActor) {
        FilmActorDBService filmActorDBService = new FilmActorDBService();
        ConvertTools convertTools = new ConvertTools();
        filmActor.setLastUpdate(convertTools.getlastUpdate());
        filmActorDBService.createFilmActor(filmActor);
    }
}
