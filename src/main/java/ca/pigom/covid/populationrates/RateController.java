package ca.pigom.covid.populationrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/rates")
public class RateController {
    @Autowired
    private RateService rateService;

    @GetMapping("/{countryId}")
    public HttpEntity<Rate> getRateByCountry(@PathVariable String countryId) {
        Rate rate = rateService.getRateDetail(countryId);
        rate.add(linkTo(methodOn(RateController.class).getRateByCountry(countryId)).withSelfRel());
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

}
