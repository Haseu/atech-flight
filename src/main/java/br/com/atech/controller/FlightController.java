package br.com.atech.controller;

import br.com.atech.entity.Flight;
import br.com.atech.service.FlightService;
import br.com.atech.specification.FlightSpecification;
import br.com.atech.specification.search.FlightSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andre on 11/12/2017.
 */
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Flight> index(FlightSearch search,
                               Pageable pageable) {

        FlightSpecification specification = new FlightSpecification(search);

        return flightService.findAll(specification, pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Flight show(@PathVariable Long id) {
        Flight flight = flightService.findById(id);
        return flight;
    }
}
