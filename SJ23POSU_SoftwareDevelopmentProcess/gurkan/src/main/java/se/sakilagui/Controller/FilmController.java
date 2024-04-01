package se.sakilagui.Controller;

import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.Service.FilmDBService;

import java.sql.Date;
import java.util.List;

public class FilmController implements FilmControllerInterface{
    @Override
    public List<FilmEntity> listAllFilm() {
        FilmDBService filmDBService = new FilmDBService();
        return filmDBService.listAllFilm();
    }

    @Override
    public List<FilmEntity> listAllByRating(String rating) {
        FilmDBService filmDBService = new FilmDBService();
        return filmDBService.listAllByRating(rating);
    }

    @Override
    public List<FilmEntity> listAllByReleaseYear(Date releaseYear) {
        return null;
    }

    @Override
    public List<FilmEntity> listAllByLanguage(String language) {
        LanguageEntity languageEntity = new LanguageEntity();
        FilmDBService filmDBService = new FilmDBService();
        LanguageController languageController = new LanguageController();
        languageEntity = languageController.getLanguageByName(language);
        List<FilmEntity> filmEntityList = filmDBService.listAllByLanguage(languageEntity);

        return filmEntityList;
    }

    @Override
    public FilmEntity getFilmById(int id) {
        FilmDBService filmDBService = new FilmDBService();
        FilmEntity filmEntity = filmDBService.getFilmById((short)id);
        System.out.println("From-Controller" + filmEntity);

        return filmEntity;
    }

    @Override
    public FilmEntity getFilmByTitel(String titel) {
        return null;
    }

    @Override
    public void deleteFilmById(int id) {

    }


}
