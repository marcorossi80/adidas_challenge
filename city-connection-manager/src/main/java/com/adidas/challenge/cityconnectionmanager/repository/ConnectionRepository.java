package com.adidas.challenge.cityconnectionmanager.repository;

import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionEntity;
import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConnectionRepository extends CrudRepository<ConnectionEntity, ConnectionKey> {

    @Query("SELECT c FROM ConnectionEntity c WHERE UPPER(c.city) = UPPER(:city) AND UPPER(c.destinyCity) = UPPER(:destinyCity)")
    List<ConnectionEntity> findByCityAndDestinyCity(@Param("city") String city, @Param("destinyCity") String destinyCity);

}
