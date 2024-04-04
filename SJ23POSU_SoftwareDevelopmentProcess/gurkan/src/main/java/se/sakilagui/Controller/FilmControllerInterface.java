package se.sakilagui.Controller;



import se.sakilagui.jpa.model.Category;

import java.util.List;

public interface FilmControllerInterface {

    List<Category.FilmEntity> listAllFilm();

    List<Category.FilmEntity> listAllByRating(String rateting);

    List<Category.FilmEntity> listAllByReleaseYear(String releaseYear);

    List<Category.FilmEntity> listAllByLanguage(String language);

    Category.FilmEntity getFilmById(int id);

    List<Category.FilmEntity> getFilmByTitel(String titel);

    Category.FilmEntity createFilm(Category.FilmEntity film);

    void deleteFilmById(int id);
}
