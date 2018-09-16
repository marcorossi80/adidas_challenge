package com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class ConnectionInstanceEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String city;

        private String destinyCity;

        private LocalDateTime departureTime;

        private LocalDateTime arrivalTime;
}
