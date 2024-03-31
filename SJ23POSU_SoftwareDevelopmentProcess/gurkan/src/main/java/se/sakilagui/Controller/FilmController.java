package se.sakilagui.Controller;

import se.sakilagui.Model.FilmEntity;
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
    public List<FilmEntity> listAllByRating(String rateting) {
        return null;
    }

    @Override
    public List<FilmEntity> listAllByReleaseYear(Date releaseYear) {
        return null;
    }

    @Override
    public List<FilmEntity> listAllByLanguageId(int languageId) {
        return null;
    }
}
