package se.sakilagui.Controller;

import se.sakilagui.Model.FilmEntity;

import java.sql.Date;
import java.util.List;

public interface FilmControllerInterface {

    List<FilmEntity> listAllFilm();

    List<FilmEntity> listAllByRating(String rateting);

    List<FilmEntity> listAllByReleaseYear(Date releaseYear);

    List<FilmEntity> listAllByLanguage(String language);

    FilmEntity getFilmById(int id);

    FilmEntity getFilmByTitel(String titel);

    void deleteFilmById(int id);
}
