package org.CustomerManager.DBService;

import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Consert;

import java.util.List;

public interface ConsertDBInterface {

    public int create(Consert consert);

    public Consert getConsertById(int id);

    public List<Consert> ListConsert();

    public Consert updateConserta(Consert consert);

    void deleteConsertById(int id);

}
