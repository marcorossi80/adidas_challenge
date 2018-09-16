package com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ConnectionKey implements Serializable {

    private String city;

    private String destinyCity;

}
