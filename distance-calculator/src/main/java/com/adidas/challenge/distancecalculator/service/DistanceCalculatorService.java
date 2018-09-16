package com.adidas.challenge.distancecalculator.service;

import com.adidas.challenge.distancecalculator.service.model.CalculationMode;
import com.adidas.challenge.distancecalculator.service.model.Journey;

public interface DistanceCalculatorService {


    Journey calculateShortestPath(String city, String destinyCity, CalculationMode calculationMode);
}
