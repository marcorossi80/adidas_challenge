package com.adidas.challenge.cityconnectionmanager.repository;

import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionInstanceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConnectionInstanceRepository extends CrudRepository<ConnectionInstanceEntity, Long> {

    @Query("SELECT c FROM ConnectionInstanceEntity c WHERE UPPER(c.city) = UPPER(:city) AND UPPER(c.destinyCity) = UPPER(:destinyCity)")
    List<ConnectionInstanceEntity> findByCityAndDestinyCity(@Param("city") String city, @Param("destinyCity") String destinyCity);

}
