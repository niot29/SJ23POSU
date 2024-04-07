package se.sakilagui.Controller;

import se.sakilagui.Model.StoreEntity;
import se.sakilagui.Service.ConvertTools;
import se.sakilagui.Service.StoreDBServices;
import se.sakilagui.Service.StoreDBServicesInterface;

import java.util.List;

public class StoreController implements StoreDBServicesInterface {



    @Override
    public void create(StoreEntity store) {
        StoreDBServices storeDBServices = new StoreDBServices();
        ConvertTools convertTools = new ConvertTools();
        store.setLastUpdate(convertTools.getlastUpdate()); // Set timestamp
        storeDBServices.create(store);
    }

    @Override
    public StoreEntity getStoreById(int id) {
        StoreDBServices storeDBServices = new StoreDBServices();
        return storeDBServices.getStoreById(id);
    }

    @Override
    public List<StoreEntity> listStores() {
        return null;
    }

    @Override
    public StoreEntity updateStore(StoreEntity store) {
        return null;
    }

    @Override
    public void deleteStoreById(int id) {

    }
}
