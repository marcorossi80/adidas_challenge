package com.adidas.challenge.cityconnectionmanager.repository;

import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionInstanceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConnectionInstanceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ConnectionInstanceRepository connectionInstanceRepository;

    @Test
    public void testInsertAndReadConnection() {
        ConnectionInstanceEntity connection = ConnectionInstanceEntity.builder()
                .city("Zaragoza")
                .destinyCity("Huesca")
                .departureTime(LocalDateTime.of(2018, 9 , 12, 13, 55))
                .arrivalTime(LocalDateTime.of(2018, 9 , 12, 14, 55))
                .build();
        entityManager.persist(connection);

        Iterable<ConnectionInstanceEntity> all = connectionInstanceRepository.findAll();

        assertEquals(1, all.spliterator().getExactSizeIfKnown());

        ConnectionInstanceEntity readConnection = all.iterator().next();

        assertEquals("Zaragoza", readConnection.getCity());
        assertEquals("Huesca", readConnection.getDestinyCity());
        assertEquals(LocalDateTime.of(2018, 9 , 12, 13, 55), readConnection.getDepartureTime());
        assertEquals(LocalDateTime.of(2018, 9 , 12, 14, 55), readConnection.getArrivalTime());
    }

    @Test
    public void testFindByCityAndDestinyCity() {
        ConnectionInstanceEntity connection = ConnectionInstanceEntity.builder()
                .city("Zaragoza")
                .destinyCity("Huesca")
                .departureTime(LocalDateTime.of(2018, 9 , 12, 13, 55))
                .arrivalTime(LocalDateTime.of(2018, 9 , 12, 14, 55))
                .build();
        entityManager.persist(connection);

        List<ConnectionInstanceEntity> all = connectionInstanceRepository.findByCityAndDestinyCity("Zaragoza", "Huesca");

        assertEquals(1, all.spliterator().getExactSizeIfKnown());

        ConnectionInstanceEntity readConnection = all.iterator().next();

        assertEquals("Zaragoza", readConnection.getCity());
        assertEquals("Huesca", readConnection.getDestinyCity());
        assertEquals(LocalDateTime.of(2018, 9 , 12, 13, 55), readConnection.getDepartureTime());
        assertEquals(LocalDateTime.of(2018, 9 , 12, 14, 55), readConnection.getArrivalTime());
    }

}