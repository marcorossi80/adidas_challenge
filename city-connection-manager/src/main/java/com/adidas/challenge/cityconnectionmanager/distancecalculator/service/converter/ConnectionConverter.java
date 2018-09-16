package com.adidas.challenge.cityconnectionmanager.distancecalculator.service.converter;

import com.adidas.challenge.cityconnectionmanager.distancecalculator.model.Connection;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model.ConnectionEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConnectionConverter implements Converter<Connection, ConnectionEntity>{

    @Override
    public ConnectionEntity convert(Connection source) {
        return ConnectionEntity.builder()
                .city(source.getCity().toUpperCase()) //The city name will always be stored in upper case
                .destinyCity(source.getDestinyCity().toUpperCase()) //The city name will always be stored in upper case
                .meanTime(source.getMeanTime())
                .build();
    }
}
