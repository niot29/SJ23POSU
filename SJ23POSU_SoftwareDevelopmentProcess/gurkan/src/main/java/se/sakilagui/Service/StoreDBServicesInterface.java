package se.sakilagui.Service;

import se.sakilagui.Model.StoreEntity;

import java.util.List;

public interface StoreDBServicesInterface {
    public void create(StoreEntity store);

    public StoreEntity getStoreById(int id);

    public List<StoreEntity> listStores();

    public StoreEntity updateStore(StoreEntity store);

    public void deleteStoreById(int id);
}
