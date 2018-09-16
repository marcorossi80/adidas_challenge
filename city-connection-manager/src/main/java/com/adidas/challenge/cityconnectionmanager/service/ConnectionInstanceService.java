package com.adidas.challenge.cityconnectionmanager.service;

import com.adidas.challenge.cityconnectionmanager.model.ConnectionInstance;

import java.util.List;

public interface ConnectionInstanceService {

    ConnectionInstance create(ConnectionInstance connectionInstance);

    ConnectionInstance read(long id);

    ConnectionInstance update(long id, ConnectionInstance connectionInstance);

    void delete(long id);

    List<ConnectionInstance> getAll();
}
