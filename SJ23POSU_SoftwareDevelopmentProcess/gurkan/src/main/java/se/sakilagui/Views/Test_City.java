package se.sakilagui.Views;

import se.sakilagui.Controller.CityController;
import se.sakilagui.Model.ActorEntity;
import se.sakilagui.Model.CityEntity;
import se.sakilagui.Model.CountryEntity;
import se.sakilagui.Service.ConvertTools;

import java.util.List;

public class Test_City {
    static CityController cityController = new CityController();
    public void createCity(){
        CountryEntity country = new CountryEntity();
        CityEntity city = new CityEntity();
        city.setCity("OSS");
        cityController.createCity(city);

    }
    public void getCityById(){
        System.out.println(cityController.getCityById(1));

    }
    public void listCity(){
        for(CityEntity cityEntity: cityController.listCity()){
            System.out.println("CityObjList: " + cityEntity);
        }
    }
    public void  updateCity(CityEntity city){

    }
    public void deleteCityById(int id){

    }
}
