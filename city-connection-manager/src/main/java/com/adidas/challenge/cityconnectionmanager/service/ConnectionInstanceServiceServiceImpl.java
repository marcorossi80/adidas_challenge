package com.adidas.challenge.cityconnectionmanager.service;

import com.adidas.challenge.cityconnectionmanager.exception.EntityNotFoundException;
import com.adidas.challenge.cityconnectionmanager.model.ConnectionInstance;
import com.adidas.challenge.cityconnectionmanager.repository.ConnectionInstanceRepository;
import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionInstanceEntity;
import com.adidas.challenge.cityconnectionmanager.service.converter.ConnectionInstanceConverter;
import com.adidas.challenge.cityconnectionmanager.service.converter.ConnectionInstanceEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ConnectionInstanceServiceServiceImpl implements ConnectionInstanceService {

    @Autowired
    ConnectionInstanceRepository connectionInstanceRepository;

    @Autowired
    ConnectionInstanceConverter connectionInstanceConverter;

    @Autowired
    ConnectionService connectionService;

    @Autowired
    ConnectionInstanceEntityConverter connectionInstanceEntityConverter;

    @Override
    public ConnectionInstance create(ConnectionInstance connectionInstance) {

        ConnectionInstanceEntity connectionInstanceEntity = connectionInstanceRepository.save(connectionInstanceConverter.convert(connectionInstance));

        connectionService.refreshConnection(connectionInstance.getCity(), connectionInstance.getDestinyCity());

        return connectionInstanceEntityConverter.convert(connectionInstanceEntity);
    }

    @Override
    public ConnectionInstance read(long id) {

        ConnectionInstanceEntity connectionInstanceEntity = connectionInstanceRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ConnectionInstanceEntity", id));

        return connectionInstanceEntityConverter.convert(connectionInstanceEntity);
    }

    @Override
    public ConnectionInstance update(long id, ConnectionInstance connectionInstance) {
        if (id != connectionInstance.getId())
            throw new IllegalArgumentException("It is not possible to update the id");
        ConnectionInstanceEntity connectionInstanceEntity = connectionInstanceRepository.save(connectionInstanceConverter.convert(connectionInstance));
        return connectionInstanceEntityConverter.convert(connectionInstanceEntity);
    }

    @Override
    public void delete(long id) {
        connectionInstanceRepository.deleteById(id);
    }

    @Override
    public List<ConnectionInstance> getAll() {

        Iterable<ConnectionInstanceEntity> allConnectionEntity = connectionInstanceRepository.findAll();
        return StreamSupport.stream(allConnectionEntity.spliterator(), false)
                .map(connectionInstanceEntity -> connectionInstanceEntityConverter.convert(connectionInstanceEntity))
                .collect(Collectors.toList());

    }

}
