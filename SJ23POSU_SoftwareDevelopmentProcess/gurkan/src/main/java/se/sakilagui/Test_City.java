package se.sakilagui;

import se.sakilagui.Controller.CityController;
import se.sakilagui.Controller.CountryController;
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

        CountryController countryController = new CountryController();
        country = countryController.getCountryById(110);
        city.setCity("OSS");
        city.setCountry(country);
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
    public void  updateCity(){
        CityEntity city1 = cityController.getCityById(601);
        CountryEntity country = new CountryEntity();
        CountryController countryController = new CountryController();
        country = countryController.getCountryById(1);
        city1.setCountry(country);
        cityController.updateCity(city1);
        System.out.println(cityController.getCityById(601));
    }
    public void deleteCityById(int id){
        cityController.deleteCityById(id);
    }
}
