package org.CustomerManager.DBService;

import org.CustomerManager.Model.Concert;

import java.util.List;

public interface ConsertDBInterface {

    public int create(Concert consert);

    public Concert getConsertById(int id);

    public List<Concert> ListConsert();

    public Concert updateConserta(Concert consert);

    void deleteConsertById(int id);

}
