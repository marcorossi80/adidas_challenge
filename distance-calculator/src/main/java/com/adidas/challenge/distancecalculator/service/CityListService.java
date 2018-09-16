package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.model.Connection;
import com.adidas.challenge.distancecalculator.service.model.City;

import java.util.List;

public interface CityListService {

    List<City> createCityList(List<Connection> allConnections);

    City getExistingCityByName(List<City> cityList, String cityName);

    void addCityToList(List<City> cityList, City city);
}
