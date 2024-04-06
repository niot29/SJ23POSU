package se.sakilagui.Controller;

import se.sakilagui.Model.FilmTextEntity;

import java.util.List;

public interface FilmTextControllerInterface {

    FilmTextEntity createFilmText(FilmTextEntity filmTextEntity);

    List<FilmTextEntity> listAllFilmText();


    List<FilmTextEntity> listAllByDesc(String text);

    FilmTextEntity getFilmTextById(int id);

    List<FilmTextEntity> getFilmByTitel(String titel);

    void deleteTextById(int id);
}
