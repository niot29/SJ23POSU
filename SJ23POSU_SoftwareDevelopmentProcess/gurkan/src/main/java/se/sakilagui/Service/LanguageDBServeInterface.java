package se.sakilagui.Service;

import se.sakilagui.Model.LanguageEntity;

public interface LanguageDBServeInterface {
    LanguageEntity getLanguageByName(String langname);
}
