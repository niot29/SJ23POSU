package se.sakilagui.Service;

import se.sakilagui.Model.FilmEntity;

import java.sql.Date;
import java.util.List;

public interface FilmDBServiceInterface {

    FilmEntity createFilm(FilmEntity film);

    List<FilmEntity> listAllFilm();

    List<FilmEntity> listAllByRating(String rateting);

    List<FilmEntity> listAllByReleaseYear(Date releaseYear);

    List<FilmEntity> listAllByLanguageId(int languageId);

    FilmEntity getFilmById(int id);

    FilmEntity getFilmByTitel(String titel);

    void deleteFilmById(int id);
}
