package se.sakilagui.Service;

import se.sakilagui.Model.CityEntity;

import java.util.List;

public interface CityDBinterface {
    public void createCity(CityEntity cityEntity);
    public CityEntity getCityById(int id);
    public List<CityEntity> listCity();
    public CityEntity updateCity(CityEntity city);
    public void deleteCityById(int id);
}
