package com.adidas.challenge.cityconnectionmanager.service;

import com.adidas.challenge.cityconnectionmanager.model.Connection;

import java.util.List;

public interface ConnectionService {
    void refreshConnection(String city, String destinyCity);

    List<Connection> getAll();
}
