package se.sakilagui.Controller;

import se.sakilagui.Model.CountryEntity;
import se.sakilagui.Service.ConvertTools;
import se.sakilagui.Service.CountryDBInterface;
import se.sakilagui.Service.CountryDBService;

import java.util.List;

public class CountryController implements CountryDBInterface {
    @Override
    public void createCountry(CountryEntity country) {
        CountryDBService countryDBService = new CountryDBService();
        ConvertTools convertTools = new ConvertTools();
        country.setLastUpdate(convertTools.getlastUpdate());
        countryDBService.createCountry(country);
    }

    @Override
    public CountryEntity getCountryById(int id) {
        CountryDBService countryDBService = new CountryDBService();
        return countryDBService.getCountryById(id);
    }

    @Override
    public List<CountryEntity> listCountry() {
        CountryDBService countryDBService = new CountryDBService();
        return countryDBService.listCountry();
    }

    @Override
    public CountryEntity updateCountry(CountryEntity country) {
        CountryDBService countryDBService = new CountryDBService();
        ConvertTools convertTools = new ConvertTools();
        country.setLastUpdate(convertTools.getlastUpdate());
        countryDBService.updateCountry(country);

        return getCountryById(country.getId());
    }

    @Override
    public void deleteCountryById(int id) {
        CountryDBService countryDBService = new CountryDBService();
        countryDBService.deleteCountryById(id);
    }
}
