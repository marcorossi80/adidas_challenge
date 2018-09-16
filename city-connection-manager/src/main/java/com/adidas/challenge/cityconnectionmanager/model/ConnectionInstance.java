package com.adidas.challenge.cityconnectionmanager.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel(value = "Connection between two cities that have been done on a specific day and time.")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionInstance {

    @ApiModelProperty(value = "Identifier.", example = "123", required = false)
    private Long id;

    @ApiModelProperty(value = "First city of the connection.", example = "Huesca", required = true)
    private String city;

    @ApiModelProperty(value = "Destiny city of the connection.", example = "Zaragoza", required = true)
    private String destinyCity;

    //@JsonFormat(pattern="yyyy-MM-ddThh:mm:ss")
    @ApiModelProperty(value = "Departure time.", example = "2018-09-15T20:02", required = true)
    private LocalDateTime departureTime;

    //@JsonFormat(pattern="yyyy-MM-ddThh:mm:ss")
    @ApiModelProperty(value = "First city of the connection.", example = "2018-09-15T21:02", required = true)
    private LocalDateTime arrivalTime;

}
