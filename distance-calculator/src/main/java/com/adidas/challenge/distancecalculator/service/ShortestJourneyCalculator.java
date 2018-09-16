package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.exception.NotFoundException;
import com.adidas.challenge.distancecalculator.service.model.City;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Inspired by https://www.baeldung.com/java-dijkstra
public abstract class ShortestJourneyCalculator {

        public List<City> calculateShortestPathFromSource(List<City> allCities, City city, City destinationCity) {
            city.setMeanTime(0D);

            Set<City> settledCities = new HashSet<>();
            Set<City> unsettledCities = new HashSet<>();

            unsettledCities.addAll(allCities);

            while (unsettledCities.size() != 0) {
                City currentCity = getLowestMeanTimeCity(unsettledCities);

                if(currentCity == null)
                    throw new NotFoundException("No journey from " + city.getName() + " to " +
                            destinationCity.getName() + " has not been found.");

                unsettledCities.remove(currentCity);
                if (currentCity.getDestinations() != null) {
                    for (Map.Entry<City, Double> adjacencyPair :
                            currentCity.getDestinations().entrySet()) {
                        City adjacentCity = adjacencyPair.getKey();
                        double meanTime = adjacencyPair.getValue();
                        if (!settledCities.contains(adjacentCity)) {
                            calculateMinimumMeanTime(adjacentCity, meanTime, currentCity);
                            unsettledCities.add(adjacentCity);
                        }
                    }
                }
                settledCities.add(currentCity);
                //Check if the destination city has been reached
                if (currentCity == destinationCity)
                    return currentCity.getShortestPath();
            }

            throw new NotFoundException("No journey from " + city.getName() + " to " +
                    destinationCity.getName() + " has not been found.");
        }

        private City getLowestMeanTimeCity(Set < City > unsettledCities) {
            City lowestMeanTimeCity = null;
            double lowestMeanTime = Integer.MAX_VALUE;
            for (City city: unsettledCities) {
                double cityMeanTime = city.getMeanTime();
                if (cityMeanTime < lowestMeanTime) {
                    lowestMeanTime = cityMeanTime;
                    lowestMeanTimeCity = city;
                }
            }
            return lowestMeanTimeCity;
        }

        abstract void calculateMinimumMeanTime(City evaluationCity, Double meanTime, City sourceCity) ;

    }
