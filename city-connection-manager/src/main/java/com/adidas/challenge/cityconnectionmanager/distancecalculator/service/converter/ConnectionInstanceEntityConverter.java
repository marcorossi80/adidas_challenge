package com.adidas.challenge.cityconnectionmanager.distancecalculator.service.converter;

import com.adidas.challenge.cityconnectionmanager.distancecalculator.model.ConnectionInstance;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model.ConnectionInstanceEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConnectionInstanceEntityConverter implements Converter<ConnectionInstanceEntity, ConnectionInstance>{

    @Override
    public ConnectionInstance convert(ConnectionInstanceEntity source) {
        return ConnectionInstance.builder()
                .id(source.getId())
                .city(source.getCity())
                .destinyCity(source.getDestinyCity())
                .departureTime(source.getDepartureTime())
                .arrivalTime(source.getArrivalTime())
                .build();
    }
}
