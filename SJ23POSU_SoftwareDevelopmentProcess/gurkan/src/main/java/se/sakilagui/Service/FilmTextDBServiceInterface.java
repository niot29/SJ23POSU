package se.sakilagui.Service;

import se.sakilagui.Model.FilmEntity;
import se.sakilagui.Model.FilmTextEntity;
import se.sakilagui.Model.LanguageEntity;

import java.sql.Date;
import java.util.List;

public interface FilmTextDBServiceInterface {

    FilmTextEntity createFilmText(FilmTextEntity filmTextEntity);

    List<FilmTextEntity> listAllFilmText();


    List<FilmTextEntity> listAllByDesc(String text);

    FilmTextEntity getFilmTextById(int id);

    List<FilmTextEntity> getFilmByTitel(String titel);

    void deleteTextById(int id);
}
