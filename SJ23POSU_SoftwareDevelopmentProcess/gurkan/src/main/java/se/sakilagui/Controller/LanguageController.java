package se.sakilagui.Controller;

import se.sakilagui.Model.LanguageEntity;
import se.sakilagui.Service.LanguageDBServes;

public class LanguageController implements LanguageControllerServeInterface{
    @Override
    public LanguageEntity getLanguageByName(String langname) {
        LanguageDBServes languageDBServes = new LanguageDBServes();
        return languageDBServes.getLanguageByName(langname);

    }
}
