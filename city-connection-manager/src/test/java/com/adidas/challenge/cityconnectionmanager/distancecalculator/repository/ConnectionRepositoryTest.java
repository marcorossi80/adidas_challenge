package com.adidas.challenge.cityconnectionmanager.distancecalculator.repository;

import com.adidas.challenge.cityconnectionmanager.distancecalculator.repository.model.ConnectionEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConnectionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Test
    public void testInsertAndReadConnection() {
        ConnectionEntity connectionEntity = ConnectionEntity.builder().city("Zaragoza").destinyCity("Huesca").meanTime(53*60*60D).build();
        entityManager.persist(connectionEntity);

        Iterable<ConnectionEntity> all = connectionRepository.findAll();

        assertEquals(1, all.spliterator().getExactSizeIfKnown());

        ConnectionEntity readConnectionEntity = all.iterator().next();

        assertEquals("Zaragoza", readConnectionEntity.getCity());
        assertEquals("Huesca", readConnectionEntity.getDestinyCity());
        assert(Double.valueOf(53*60*60L).equals(readConnectionEntity.getMeanTime().doubleValue()));
    }

}