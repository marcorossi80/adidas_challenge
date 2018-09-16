package com.adidas.challenge.cityconnectionmanager.service.converter;

import com.adidas.challenge.cityconnectionmanager.model.Connection;
import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConnectionEntityConverter implements Converter<ConnectionEntity, Connection>{

    @Override
    public Connection convert(ConnectionEntity source) {
        return Connection.builder()
                .city(source.getCity())
                .destinyCity(source.getDestinyCity())
                .meanTime(source.getMeanTime())
                .build();
    }

}
