package com.adidas.challenge.distancecalculator.client;

import com.adidas.challenge.distancecalculator.model.Connection;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("city-connection-manager")
public interface CityConnectionManagerClient {

    @RequestMapping(value = "/connection/", method = RequestMethod.GET, consumes = "application/json")
    List<Connection> getAllConnections();
}
