package com.adidas.challenge.cityconnectionmanager.distancecalculator.service.converter;

import com.adidas.challenge.cityconnectionmanager.distancecalculator.model.ConnectionInstance;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model.ConnectionInstanceEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConnectionInstanceConverter implements Converter<ConnectionInstance, ConnectionInstanceEntity>{

    @Override
    public ConnectionInstanceEntity convert(ConnectionInstance source) {
        return ConnectionInstanceEntity.builder()
                .id(source.getId())
                .city(source.getCity().toUpperCase()) //The city name will always be stored in upper case
                .destinyCity(source.getDestinyCity().toUpperCase()) //The city name will always be stored in upper case
                .departureTime(source.getDepartureTime())
                .arrivalTime(source.getArrivalTime())
                .build();
    }
}
