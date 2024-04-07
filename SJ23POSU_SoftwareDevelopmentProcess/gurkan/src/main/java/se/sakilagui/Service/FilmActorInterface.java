package se.sakilagui.Service;
import se.sakilagui.Model.FilmActorEntity;
import se.sakilagui.jpa.model.FilmActorId;

import java.util.List;

public interface FilmActorInterface {
    void createFilmActor(FilmActorEntity filmActor);
    List<FilmActorEntity> getFilmActorById(FilmActorEntity id);
    List<FilmActorEntity> getAllFilmActors();
    FilmActorEntity updateFilmActor(FilmActorEntity filmActor);
    void deleteFilmActorById(FilmActorEntity id);
}
