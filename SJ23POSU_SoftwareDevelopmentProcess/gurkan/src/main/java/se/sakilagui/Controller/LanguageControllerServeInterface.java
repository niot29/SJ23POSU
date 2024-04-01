package se.sakilagui.Controller;

import se.sakilagui.Model.LanguageEntity;

public interface LanguageControllerServeInterface {
    LanguageEntity getLanguageByName(String langname);
}
