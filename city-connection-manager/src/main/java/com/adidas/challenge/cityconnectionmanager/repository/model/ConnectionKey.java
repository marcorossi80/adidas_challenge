package com.adidas.challenge.cityconnectionmanager.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionKey implements Serializable {

    private String city;

    private String destinyCity;

}
