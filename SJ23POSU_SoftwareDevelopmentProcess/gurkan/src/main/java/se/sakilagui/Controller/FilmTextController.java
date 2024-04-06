package se.sakilagui.Controller;

import se.sakilagui.Model.FilmTextEntity;
import se.sakilagui.Service.FilmTextDBService;
import se.sakilagui.Service.FilmTextDBServiceInterface;

import java.util.List;

public class FilmTextController implements FilmTextDBServiceInterface {
    @Override
    public FilmTextEntity createFilmText(FilmTextEntity filmTextEntity) {
        FilmTextDBService filmTextDBService = new FilmTextDBService();
        return filmTextDBService.createFilmText(filmTextEntity);
    }

    @Override
    public List<FilmTextEntity> listAllFilmText() {
        return new FilmTextDBService().listAllFilmText();
    }

    @Override
    public List<FilmTextEntity> listAllByDesc(String text) {
        return new FilmTextDBService().listAllByDesc(text);
    }

    @Override
    public FilmTextEntity getFilmTextById(int id) {
        //FilmTextDBService filmTextDBService = new FilmTextDBService();
        //FilmTextEntity filmTextEntity = new FilmTextEntity();

        return new FilmTextDBService().getFilmTextById(id);
    }

    @Override
    public List<FilmTextEntity> getFilmByTitel(String titel) {
        return new FilmTextDBService().getFilmByTitel(titel);
    }

    @Override
    public void deleteTextById(int id) {
        new FilmTextDBService().deleteTextById(id);
    }
}
