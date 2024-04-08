package se.sakilagui.Test;

import se.sakilagui.Controller.FilmTextController;
import se.sakilagui.Model.FilmTextEntity;

public class Test_FilmText {

    static FilmTextController filmTextController = new FilmTextController();

    public void Test_FilmText_listAllFilmText(){
        for(FilmTextEntity filmTextEntity: filmTextController.listAllFilmText()){
            System.out.println("FilmTextObjList: " + filmTextEntity);
        }
    }

    void  Test_FilmText_listAllByDesc(){
        for(FilmTextEntity filmTextEntity: filmTextController.listAllByDesc("A Epic Drama ")){
            System.out.println("FilmTextObjList: " + filmTextEntity);
        }
    }

    void  Test_FilmText_getFilmByTitel(){
        for(FilmTextEntity filmTextEntity: filmTextController.getFilmByTitel("GOLDFINGER")){
            System.out.println("FilmTextObjList: " + filmTextEntity);
        }
    }

    void  Test_FilmText_getFilmById(){
        System.out.println(filmTextController.getFilmTextById(2));
    }

    void  Test_FilmText_createFilmTextAndDeleteBYID(){
        FilmTextEntity filmTextEntity = new FilmTextEntity();
        filmTextEntity.setId(1001);
        filmTextEntity.setTitle("kungen");
        filmTextEntity.setDescription("Film om Kung Nils");
        filmTextController.createFilmText(filmTextEntity);


        for(FilmTextEntity filmTextEntityList: filmTextController.getFilmByTitel(filmTextEntity.getTitle())){
            System.out.println("FilmTextObjList: " + filmTextEntityList);
        }

        filmTextController.deleteTextById(1001);
    }

}
