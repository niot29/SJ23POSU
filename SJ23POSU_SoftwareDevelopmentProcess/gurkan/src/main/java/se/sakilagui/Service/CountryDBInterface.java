package se.sakilagui.Service;

import se.sakilagui.Model.CountryEntity;

import java.util.List;

public interface CountryDBInterface {
    public void createCity(CountryEntity country);
    public CountryEntity getCountryById(int id);
    public List<CountryEntity> listCountry();
    public CountryEntity updateCountry(CountryEntity country);
    public void deleteCountryById(int id);
}
