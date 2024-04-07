package se.sakilagui.Controller;



import se.sakilagui.Model.CityEntity;
import se.sakilagui.Service.CityDBHandling;
import se.sakilagui.Service.CityDBinterface;
import se.sakilagui.Service.ConvertTools;

import java.util.List;

public class CityController implements CityDBinterface {
    @Override
    public void createCity(CityEntity city){
        CityDBHandling cityDBHandling = new CityDBHandling();
        ConvertTools convertTools = new ConvertTools();
        city.setLastUpdate(convertTools.getlastUpdate());
        cityDBHandling.createCity(city);
    }
    @Override
    public List<CityEntity> listCity() {
        CityDBHandling cityDBHandling = new CityDBHandling();
        return cityDBHandling.listCity();
    }

    @Override
    public CityEntity updateCity(CityEntity city) {
        CityDBHandling cityDBHandling = new CityDBHandling();
        ConvertTools convertTools = new ConvertTools();
        city.setLastUpdate(convertTools.getlastUpdate());
        cityDBHandling.updateCity(city);
        return cityDBHandling.getCityById(city.getId());
    }

    @Override
    public CityEntity getCityById(int id) {
        CityDBHandling cityDBHandling = new CityDBHandling();
        CityEntity cityEntity = cityDBHandling.getCityById((short) id);
        return cityEntity;
    }
    @Override
    public void deleteCityById(int id) {
        CityDBHandling cityDBHandling = new CityDBHandling();
        cityDBHandling.deleteCityById(id);
    }
}
