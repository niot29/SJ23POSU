package se.sakilagui;


import se.sakilagui.Controller.StoreController;

public class Test_Store {
    static StoreController storeController = new StoreController();
    void Test_getStoreById(){
        System.out.println("StoreObject: " + storeController.getStoreById(1));
    }
}
