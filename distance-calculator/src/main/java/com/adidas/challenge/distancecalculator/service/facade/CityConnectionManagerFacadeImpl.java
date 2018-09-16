package com.adidas.challenge.distancecalculator.service.facade;

import com.adidas.challenge.distancecalculator.client.CityConnectionManagerClient;
import com.adidas.challenge.distancecalculator.exception.BaseException;
import com.adidas.challenge.distancecalculator.model.Connection;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityConnectionManagerFacadeImpl implements CityConnectionManagerFacade {

    @Autowired
    CityConnectionManagerClient cityConnectionManagerClient;

    @Override
    public List<Connection> getAllConnections() {
        List<Connection> allConnections = null;
        try {
            allConnections = cityConnectionManagerClient.getAllConnections();
        } catch (HystrixRuntimeException | RetryableException e) {
            throw new BaseException("It has not been possible to contact the city connection manager", e);
        }
        return allConnections;
    }

}
