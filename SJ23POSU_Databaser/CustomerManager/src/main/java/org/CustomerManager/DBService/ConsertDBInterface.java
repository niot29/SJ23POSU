package org.CustomerManager.DBService;

import org.CustomerManager.Model.Concert;

import java.util.List;

public interface ConsertDBInterface {

    public void create(Concert concert);

    public Concert getConcertById(int id);

    public List<Concert> ListConcert();

    public Concert updateConcert(Concert concert);

    void deleteConcertById(int id);

}
