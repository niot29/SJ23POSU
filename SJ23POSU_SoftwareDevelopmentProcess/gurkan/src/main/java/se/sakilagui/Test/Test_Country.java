package se.sakilagui.Test;

import se.sakilagui.Controller.CountryController;
import se.sakilagui.Model.CityEntity;
import se.sakilagui.Model.CountryEntity;

import java.util.List;

public class Test_Country {

    static CountryController countryController = new CountryController();

    public void createCountry() {
        CountryEntity country = new CountryEntity("xxx");
        countryController.createCountry(country);
    }

    public void getCountryById() {
        System.out.println(countryController.getCountryById(1));

    }

    public void listCountry() {
        for (CountryEntity country : countryController.listCountry()) {
            System.out.println("CityObjList: " + country);
        }

    }

    public void updateCountry() {
        CountryEntity country = countryController.getCountryById(111);
        country.setCountry("YYY");
        countryController.updateCountry(country);
    }

    public void deleteCountryById() {
        countryController.deleteCountryById(111);
    }
}
