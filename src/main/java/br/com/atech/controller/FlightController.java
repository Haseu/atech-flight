package br.com.atech.controller;

import br.com.atech.entity.Flight;
import br.com.atech.service.FlightService;
import br.com.atech.specification.FlightSpecification;
import br.com.atech.specification.search.FlightSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public Page<Flight> index( @RequestParam(value = "departureTime", required = false) Date departureTime,
                               @RequestParam(value = "arrivalTime", required = false) Date arrivalTime,
                               @RequestParam(value = "departureCity", required = false) String departureCity,
                               @RequestParam(value = "arrivalCity", required = false) String arrivalCity,
                               @RequestParam(value = "airplane", required = false) String airplane,
                               @RequestParam(value = "pilot", required = false) String pilot,
                               @RequestParam(value = "status", required = false) String status,
                               Pageable pageable) {

        FlightSearch filter = new FlightSearch();
        FlightSpecification specification = new FlightSpecification(filter);

        return flightService.findAll(specification, pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Flight show(@PathVariable Long id) {
        Flight flight = flightService.findById(id);
        return flight;
    }
}
