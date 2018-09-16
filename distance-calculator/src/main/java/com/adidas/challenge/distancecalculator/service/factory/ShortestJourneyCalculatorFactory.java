package com.adidas.challenge.distancecalculator.service.factory;

import com.adidas.challenge.distancecalculator.exception.BaseException;
import com.adidas.challenge.distancecalculator.service.ShortestCalculatorImplConnexionsBased;
import com.adidas.challenge.distancecalculator.service.ShortestCalculatorImplTimeBased;
import com.adidas.challenge.distancecalculator.service.ShortestJourneyCalculator;
import com.adidas.challenge.distancecalculator.service.model.CalculationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShortestJourneyCalculatorFactory {

    @Autowired
    private ShortestCalculatorImplTimeBased shortestCalculatorImplTimeBased;

    @Autowired
    private ShortestCalculatorImplConnexionsBased shortestCalculatorImplConnexionsBased;

    public ShortestJourneyCalculator createCalculator(CalculationMode calculationMode) {

        switch (calculationMode) {
            case TIME:
                return shortestCalculatorImplTimeBased;
            case CONNECTIONS:
                return shortestCalculatorImplConnexionsBased;
        }
        //It is not possible that this exception is thrown
        throw new BaseException("The ShortestJourneyCalculator has not been created");
    }

}
