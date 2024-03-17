package org.CustomerManager.DBService;

import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Wc;

import java.util.List;

public interface WcDBInterface {

    public void  create(Wc wc);

    public Wc getWcById(int id);

    public List<Wc> ListWc();

    public List<Wc> ListWcByCustomerId();

    public Wc updateCustomer(Wc wc);

    void deleteWcById(int id);

}
