package com.adidas.challenge.cityconnectionmanager.controller;

import com.adidas.challenge.cityconnectionmanager.model.ConnectionInstance;
import com.adidas.challenge.cityconnectionmanager.service.ConnectionInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//TODO: If I have free time, use HETEOAS
@Api(description = "This service maintains the connections between two cities that have been done on a specific day and time.")
@RestController
public class ConnectionInstanceController {

    @Autowired
    ConnectionInstanceService connectionInstanceService;

    @ApiOperation(value = "Stores a connections between two cities that have been done on a specific day and time.")
    @RequestMapping(method = RequestMethod.POST, value = "/connection-instance/")
    public ResponseEntity<Long> create(@Valid @RequestBody ConnectionInstance connectionInstance) {
        Long id = connectionInstanceService.create(connectionInstance).getId();
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Reads a connections between two cities that have been done on a specific day and time by its identifier.")
    @RequestMapping(method = RequestMethod.GET, value = "/connection-instance/{id}")
    public ResponseEntity<ConnectionInstance> read(
            @ApiParam(value = "Id of the city connexion instance")
            @PathVariable(value = "id") long id) {
        ConnectionInstance connectionInstance = connectionInstanceService.read(id);
        return new ResponseEntity(connectionInstance, HttpStatus.OK);
    }

    @ApiOperation(value = "Updates a connections between two cities that have been done on a specific day and time by its identifier.")
    @RequestMapping(method = RequestMethod.PUT, value = "/connection-instance/{id}")
    public ResponseEntity<Void> update(
            @ApiParam(value = "Id of the city connexion instance")
            @PathVariable(value = "id") long id, @Valid @RequestBody ConnectionInstance connectionInstance) {
        connectionInstanceService.update(id, connectionInstance);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a connections between two cities that have been done on a specific day and time by its identifier.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/connection-instance/{id}")
    public ResponseEntity<Void> delete(
            @ApiParam(value = "Id of the city connexion instance")
            @PathVariable(value = "id") long id) {
        connectionInstanceService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Reads all the connections between cities that have been done on any day and time.")
    @RequestMapping(method = RequestMethod.GET, value = "/connection-instance/")
    public ResponseEntity<List<ConnectionInstance>> getAll() {
        List<ConnectionInstance> connectionInstanceList = connectionInstanceService.getAll();
        return new ResponseEntity(connectionInstanceList, HttpStatus.OK);
    }

}
