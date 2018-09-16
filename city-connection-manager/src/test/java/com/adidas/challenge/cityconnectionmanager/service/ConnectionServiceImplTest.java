package com.adidas.challenge.cityconnectionmanager.service;

import com.adidas.challenge.cityconnectionmanager.repository.ConnectionInstanceRepository;
import com.adidas.challenge.cityconnectionmanager.repository.ConnectionRepository;
import com.adidas.challenge.cityconnectionmanager.repository.model.ConnectionInstanceEntity;
import com.adidas.challenge.cityconnectionmanager.service.converter.ConnectionConverter;
import com.adidas.challenge.cityconnectionmanager.service.converter.ConnectionEntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ConnectionServiceImplTest {

    @InjectMocks
    ConnectionServiceImpl connectionService;

    @Mock
    ConnectionInstanceRepository connectionInstanceRepository;

    @Mock
    ConnectionRepository connectionRepository;

    @Mock
    ConnectionEntityConverter connectionEntityConverter;

    @Mock
    ConnectionConverter connectionConverter;


    @Test
    public void testCalculateMeanTime() {
        when(connectionInstanceRepository.findByCityAndDestinyCity("Zaragoza", "Huesca")).thenReturn(Arrays.asList(
                ConnectionInstanceEntity.builder()
                        .city("Zaragoza")
                        .destinyCity("Huesca")
                        .departureTime(LocalDateTime.of(2018, 9 , 12, 13, 55))
                        .arrivalTime(LocalDateTime.of(2018, 9 , 12, 14, 55))
                        .build(),
                ConnectionInstanceEntity.builder()
                        .city("Zaragoza")
                        .destinyCity("Huesca")
                        .departureTime(LocalDateTime.of(2018, 9 , 13, 13, 55))
                        .arrivalTime(LocalDateTime.of(2018, 9 , 13, 14, 56))
                        .build()
        ));
        when(connectionRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
                //then(returnsFirstArg());

        double meanTime = connectionService.calculateConnectionMeanTime("Zaragoza", "Huesca");
        assert(Double.valueOf(3630).equals(meanTime));


    }
}