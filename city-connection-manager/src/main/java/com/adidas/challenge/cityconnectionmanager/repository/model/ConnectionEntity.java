package com.adidas.challenge.cityconnectionmanager.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ConnectionKey.class)
public class ConnectionEntity {

    @Id
    private String city;
    @Id
    private String destinyCity;

    private Double meanTime;

}
