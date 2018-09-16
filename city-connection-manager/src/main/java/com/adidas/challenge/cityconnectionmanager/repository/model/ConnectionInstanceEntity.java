package com.adidas.challenge.cityconnectionmanager.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
