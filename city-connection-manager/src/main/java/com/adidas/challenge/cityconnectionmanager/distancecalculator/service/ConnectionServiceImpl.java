package com.adidas.challenge.cityconnectionmanager.distancecalculator.service;

import com.adidas.challenge.cityconnectionmanager.distancecalculator.model.Connection;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.ConnectionInstanceRepository;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.ConnectionRepository;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model.ConnectionEntity;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model.ConnectionInstanceEntity;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.service.converter.ConnectionConverter;
import com.adidas.challenge.cityconnectionmanager.distancecalculator.service.converter.ConnectionEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    ConnectionInstanceRepository connectionInstanceRepository;

    @Autowired
    ConnectionRepository connectionRepository;

    @Autowired
    ConnectionEntityConverter connectionEntityConverter;

    @Autowired
    ConnectionConverter connectionConverter;

    @Override
    @Async
    public void refreshConnection(String city, String destinyCity) {

        double meanTime = calculateConnectionMeanTime(city, destinyCity);

        Connection connection = Connection.builder()
                .city(city)
                .destinyCity(destinyCity)
                .meanTime(meanTime)
                .build();

        save(connection);
    }

    public double calculateConnectionMeanTime(String city, String destinyCity) {
        List<ConnectionInstanceEntity> connectionInstanceList = connectionInstanceRepository.findByCityAndDestinyCity(city, destinyCity);
        double meanTime = connectionInstanceList.stream()
                .map(ci -> Duration.between(ci.getDepartureTime(), ci.getArrivalTime())
                        .getSeconds())
                .mapToDouble(n -> n)
                .average()
                .getAsDouble();
        return meanTime;
    }

    private Connection save (Connection connection){
        ConnectionEntity connectionEntity = connectionRepository.save(connectionConverter.convert(connection));
        return connectionEntityConverter.convert(connectionEntity);
    }

    @Override
    public List<Connection> getAll() {
        Iterable<ConnectionEntity> allConnectionEntity = connectionRepository.findAll();
        return StreamSupport.stream(allConnectionEntity.spliterator(), false)
                .map(connectionEntity -> connectionEntityConverter.convert(connectionEntity))
                .collect(Collectors.toList());
    }

}
