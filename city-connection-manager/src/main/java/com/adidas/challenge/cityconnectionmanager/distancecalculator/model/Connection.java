package com.adidas.challenge.cityconnectionmanager.distancecalculator.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "Connection between two cities. " +
        "The mean time is the mean of the duration of all the instances of the connexions done.")
@Data
@Builder
public class Connection {

    @ApiModelProperty(value = "First city of the connection.", example = "Huesca")
    private String city;

    @ApiModelProperty(value = "Destiny city of the connection.", example = "Zaragoza")
    private String destinyCity;

    @ApiModelProperty(value = "Mean time of the connection in seconds.", example = "3600")
    private Double meanTime;

}
