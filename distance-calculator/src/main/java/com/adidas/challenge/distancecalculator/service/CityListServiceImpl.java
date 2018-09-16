package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.exception.NotFoundException;
import com.adidas.challenge.distancecalculator.model.Connection;
import com.adidas.challenge.distancecalculator.service.model.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityListServiceImpl implements CityListService {

    @Override
    public List<City> createCityList(List<Connection> allConnections) {

        List<City> cityList = new ArrayList<>();
        for(Connection connection: allConnections) {
            City city = getCityByName(cityList, connection.getCity());
            City destinyCity = getCityByName(cityList, connection.getDestinyCity());
            city.addDestination(destinyCity, connection.getMeanTime());
            addCityToList(cityList, city);
            //Ensures that all the cities are added even if they are not origin of any connection
            addCityToList(cityList, destinyCity);
        }

        return cityList;

    }

    private City getCityByName(List<City> cityList, String cityName) {
        return cityList.stream()
                .filter(city -> cityName.equals(city.getName()))
                .findFirst()
                .orElse(City.builder().name(cityName).build());
    }

    @Override
    public City getExistingCityByName(List<City> cityList, String cityName) {
        return  cityList.stream()
                .filter(city -> cityName.equals(city.getName()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("The city " + cityName +" has not been found."));
    }

    @Override
    public void addCityToList(List<City> cityList, City city) {
        if(!cityList.contains(city)) {
            cityList.add(city);
        }
    }
}
