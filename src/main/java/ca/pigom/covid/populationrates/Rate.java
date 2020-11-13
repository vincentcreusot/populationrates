package ca.pigom.covid.populationrates;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigInteger;

public class Rate extends RepresentationModel<Rate> {
    public String getCountry() {
        return country;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public BigInteger getDeaths() {
        return deaths;
    }

    public double getRate() {
        return rate;
    }

    private final String country;
    private final BigInteger population;
    private final BigInteger deaths;
    private final double rate;

    @JsonCreator
    public Rate(@JsonProperty("country") String country,
                @JsonProperty("population") BigInteger population,
                @JsonProperty("deaths") BigInteger deaths,
                @JsonProperty("rate") double rate) {
        this.country = country;
        this.population = population;
        this.deaths = deaths;
        this.rate = rate;
    }



}
