package com.adidas.challenge.cityconnectionmanager.controller;

import com.adidas.challenge.cityconnectionmanager.model.Connection;
import com.adidas.challenge.cityconnectionmanager.service.ConnectionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "This service return a list of all the connections stored in the data base.")
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    @RequestMapping(method = RequestMethod.GET, value = "/connection/")
    public ResponseEntity<List<Connection>> getAll() {

        List<Connection> connectionList = connectionService.getAll();

        return new ResponseEntity(connectionList, HttpStatus.OK);
    }

}
