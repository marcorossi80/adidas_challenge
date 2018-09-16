package com.adidas.challenge.distancecalculator.controller;

import com.adidas.challenge.distancecalculator.service.DistanceCalculatorService;
import com.adidas.challenge.distancecalculator.service.model.CalculationMode;
import com.adidas.challenge.distancecalculator.service.model.Journey;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;

@RestController
@Api(description = "This service calculates the shortest journey (in time and in connections) " +
        "to travel from one city to another.")
public class DistanceCalculatorController {

    @Autowired
    DistanceCalculatorService distanceCalculatorService;


    @RequestMapping(method = RequestMethod.GET, value = "/calculate-shortest/{city}/{destiny-city}")
    @ApiOperation(value = "Returns the shortest journey.")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "The shortest journey with a list of stages."),
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "It is returned if the city or the destiny-city cannot be found. " +
                    "It is also returned if there is no connection between the cities."),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal Server Error."),
    })
    public ResponseEntity<Journey> calculate(@ApiParam(value = "Name of the departure city.", example = "Huesca", required = true)
                                                 @PathVariable(value = "city") String city,
                                             @ApiParam(value = "Name of the destiny city.", example = "Zaragoza", required = true)
                                             @PathVariable(value = "destiny-city") String destinyCity,
                                             @ApiParam(value = "Mode of calculation.", example = "TIME", required = true)
                                             @RequestParam(value = "calculation-mode") CalculationMode calculationMode) {

        Journey journey = distanceCalculatorService.calculateShortestPath(city, destinyCity, calculationMode);

        return new ResponseEntity(journey, HttpStatus.OK);
    }

}
