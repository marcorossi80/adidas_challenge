package com.adidas.challenge.distancecalculator.service.model;

import lombok.Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Builder
public class City {

    private String name;

    //This attribute will store the fastest path to arrive to the city
    private List<City> shortestPath;

    //This attribute will store the minimum mean time that it takes to arrive to this city from the origin city
    private Double meanTime;

    Map<City, Double> destinations;

    public void addDestination(City destinyCity, Double meanTime) {
        if (destinations == null)
             destinations = new HashMap<>();
        destinations.put(destinyCity, meanTime);
    }

    public String getName() {
        return name;
    }

    public Double getMeanTime() {
        if (meanTime == null)
            return Double.MAX_VALUE;
        return meanTime;
    }

    public void setMeanTime(Double meanTime) {
        this.meanTime = meanTime;
    }

    public List<City> getShortestPath() {
        if (shortestPath == null)
            shortestPath = new ArrayList<>();
        return shortestPath;
    }

    public void setShortestPath(List<City> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Map<City, Double> getDestinations() {
        return destinations;
    }
}
