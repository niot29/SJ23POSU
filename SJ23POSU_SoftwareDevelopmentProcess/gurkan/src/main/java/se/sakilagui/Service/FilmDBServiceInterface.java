package se.sakilagui.Service;

import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;

import java.sql.Date;
import java.util.List;

public interface FilmDBServiceInterface {

    FilmEntity createFilm(FilmEntity film);

    List<FilmEntity> listAllFilm();

    List<FilmEntity> listAllByRating(String rating);

    List<FilmEntity> listAllByReleaseYear(Date releaseYear);

    List<FilmEntity> listAllByLanguage(LanguageEntity language);

    List<FilmEntity> listAllByCategory(String category);

    FilmEntity getFilmById(int id);

    List<FilmEntity> getFilmByTitel(String titel);

    void deleteFilmById(int id);
}
