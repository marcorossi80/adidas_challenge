package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.service.model.City;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ShortestCalculatorImplTimeBased extends ShortestJourneyCalculator {

    void calculateMinimumMeanTime(City evaluationCity, Double meanTime, City sourceCity) {
        double sourceMeanTime = sourceCity.getMeanTime();
        if (sourceMeanTime + meanTime < evaluationCity.getMeanTime()) {
            evaluationCity.setMeanTime(sourceMeanTime + meanTime);
            LinkedList<City> shortestPath = new LinkedList<>(sourceCity.getShortestPath());
            shortestPath.add(sourceCity);
            evaluationCity.setShortestPath(shortestPath);
        }
    }

}
