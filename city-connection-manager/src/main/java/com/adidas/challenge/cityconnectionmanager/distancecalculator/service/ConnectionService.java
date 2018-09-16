package com.adidas.challenge.cityconnectionmanager.distancecalculator.service;

import com.adidas.challenge.cityconnectionmanager.distancecalculator.model.Connection;

import java.util.List;

public interface ConnectionService {
    void refreshConnection(String city, String destinyCity);

    List<Connection> getAll();
}
