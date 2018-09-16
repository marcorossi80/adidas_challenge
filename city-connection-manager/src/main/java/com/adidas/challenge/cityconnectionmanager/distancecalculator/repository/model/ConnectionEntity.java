package com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Builder
@Entity
@IdClass(ConnectionKey.class)
public class ConnectionEntity {

    @Id
    private String city;
    @Id
    private String destinyCity;

    private Double meanTime;

}
