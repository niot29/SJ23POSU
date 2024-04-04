package se.sakilagui.Service;

import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.jpa.model.Category;

import java.sql.Date;
import java.util.List;

public interface FilmDBServiceInterface {

    Category.FilmEntity createFilm(Category.FilmEntity film);

    List<Category.FilmEntity> listAllFilm();

    List<Category.FilmEntity> listAllByRating(String rating);

    List<Category.FilmEntity> listAllByReleaseYear(Date releaseYear);

    List<Category.FilmEntity> listAllByLanguage(LanguageEntity language);

    List<Category.FilmEntity> listAllByCategory(String category);

    Category.FilmEntity getFilmById(int id);

    List<Category.FilmEntity> getFilmByTitel(String titel);

    void deleteFilmById(int id);
}
