package com.adidas.challenge.distancecalculator.service.facade;

import com.adidas.challenge.distancecalculator.model.Connection;

import java.util.List;

public interface CityConnectionManagerFacade {
    List<Connection> getAllConnections();
}
