package ca.pigom.covid.populationrates;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class RateService {

    public Rate getRateDetail(String country) {
        return new Rate("france",
                BigInteger.valueOf(70000000),
                BigInteger.valueOf(45000),
                45000d / 70000000d);
    }

}
