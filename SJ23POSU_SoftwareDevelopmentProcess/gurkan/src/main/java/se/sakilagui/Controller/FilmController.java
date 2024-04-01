package se.sakilagui.Controller;

import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.Service.ConvertTools;
import se.sakilagui.Service.FilmDBService;

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
    public List<FilmEntity> listAllByReleaseYear(String releaseYear) {
        FilmDBService filmDBService = new FilmDBService();
        ConvertTools convertTools = new ConvertTools();
        java.sql.Date sqlDate = convertTools.ConvertStrToSqlDate("yyyy",releaseYear);
        /*
        Date year = null;
        DateFormat df = new SimpleDateFormat("yyyy");
        java.sql.Date sqlDate;

        try {
            year = (Date) df.parse(releaseYear);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        sqlDate = new java.sql.Date(year.getTime());
        System.out.println(sqlDate);

        */

        return filmDBService.listAllByReleaseYear(sqlDate);
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
