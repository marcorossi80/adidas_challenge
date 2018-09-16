package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.service.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ShortestCalculatorImplTimeBasedTest {

    //@Mock

    @InjectMocks
    private ShortestCalculatorImplTimeBased shortestJourneyCalculator;

    @Test
    public void calculateShortestPathFromSource()  {

        City cityA = City.builder().name("A").build();
        City cityB = City.builder().name("B").build();
        City cityC = City.builder().name("C").build();
        City cityD = City.builder().name("D").build();
        City cityE = City.builder().name("E").build();
        City cityF = City.builder().name("F").build();

        cityA.addDestination(cityB, 10D);
        cityA.addDestination(cityC, 15D);

        cityB.addDestination(cityD, 12D);
        cityB.addDestination(cityF, 15D);

        cityC.addDestination(cityE, 10D);

        cityD.addDestination(cityE, 2D);
        cityD.addDestination(cityF, 1D);

        cityF.addDestination(cityE, 5D);

        List<City> allCities = new ArrayList<>();

        allCities.add(cityA);
        allCities.add(cityB);
        allCities.add(cityC);
        allCities.add(cityD);
        allCities.add(cityE);
        allCities.add(cityF);

        List<City> shortestJourney = shortestJourneyCalculator.calculateShortestPathFromSource(allCities, cityA, cityE);

    }


}