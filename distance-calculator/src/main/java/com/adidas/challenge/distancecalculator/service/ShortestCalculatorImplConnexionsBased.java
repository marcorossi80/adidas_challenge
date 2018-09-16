package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.service.model.City;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ShortestCalculatorImplConnexionsBased extends ShortestJourneyCalculator {

    void calculateMinimumMeanTime(City evaluationCity,
                                                 Double meanTime, City sourceCity) {
        //We use 1 as the time of each connection
        double sourceMeanTime = sourceCity.getMeanTime();
        if (sourceMeanTime + 1 < evaluationCity.getMeanTime()) {
            evaluationCity.setMeanTime(sourceMeanTime + 1);
            LinkedList<City> shortestPath = new LinkedList<>(sourceCity.getShortestPath());
            shortestPath.add(sourceCity);
            evaluationCity.setShortestPath(shortestPath);
        }
    }

}
