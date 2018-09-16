package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.model.Connection;
import com.adidas.challenge.distancecalculator.service.facade.CityConnectionManagerFacade;
import com.adidas.challenge.distancecalculator.service.factory.ShortestJourneyCalculatorFactory;
import com.adidas.challenge.distancecalculator.service.model.CalculationMode;
import com.adidas.challenge.distancecalculator.service.model.City;
import com.adidas.challenge.distancecalculator.service.model.Journey;
import com.adidas.challenge.distancecalculator.service.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistanceCalculatorServiceServiceImpl implements DistanceCalculatorService {

    @Autowired
    ShortestJourneyCalculatorFactory shortestJourneyCalculatorFactory;

    @Autowired
    CityConnectionManagerFacade cityConnectionManagerFacade;

    @Autowired
    CityListService cityListService;

    @Override
    public Journey calculateShortestPath(String cityName, String destinyCityName, CalculationMode calculationMode) {

        List<Connection> allConnections = cityConnectionManagerFacade.getAllConnections();
        List<City> allCities = cityListService.createCityList(allConnections);

        ShortestJourneyCalculator calculator = shortestJourneyCalculatorFactory.createCalculator(calculationMode);
        City city = cityListService.getExistingCityByName(allCities, cityName.toUpperCase());
        City destinyCity = cityListService.getExistingCityByName(allCities, destinyCityName.toUpperCase());
        List<City> shortestCityList = calculator.calculateShortestPathFromSource(allCities, city, destinyCity);
        return new Journey(createStageList(shortestCityList, destinyCity));
    }

    private List<Stage> createStageList(List<City> shortestCityList, City destinyCity) {
        shortestCityList.add(destinyCity);
        return shortestCityList.stream().map(c -> Stage.builder().city(c.getName()).meanTime(c.getMeanTime()).build()).collect(Collectors.toList());
    }
}
