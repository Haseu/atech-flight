package br.com.atech.service.impl;

import br.com.atech.entity.Flight;
import br.com.atech.repository.FlightRepository;
import br.com.atech.service.FlightService;
import br.com.atech.specification.FlightSpecification;
import br.com.atech.specification.search.FlightSearch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by andre on 13/12/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightServiceImplTest {

    @Mock
    private FlightRepository repository;

    private FlightService service;

    @Before
    public void setUp() {
        service = new FlightServiceImpl(repository);
    }

    @Test
    public void findAll() throws Exception {

        final Pageable pageable = new PageRequest(0, 10, Sort.Direction.ASC, "id");

        final Flight flight1 = new Flight();
        flight1.setId(1L);
        final Flight flight2 = new Flight();
        flight2.setId(2L);

        final List<Flight> flights = Arrays.asList(flight1, flight2);
        final Page<Flight> expectedFlights = new PageImpl<>(flights);

        FlightSearch search = new FlightSearch();
        FlightSpecification specification = new FlightSpecification(search);

        when(repository.findAll(any(FlightSpecification.class),any(Pageable.class))).thenReturn(expectedFlights);

        Page<Flight> flightsPage = this.service.findAll(specification, pageable);

        verify(repository, times(1)).findAll(specification, pageable);
        assertEquals("Should return a list of flights", expectedFlights, flightsPage);
        assertEquals(expectedFlights.getTotalElements(), flightsPage.getTotalElements());
    }

    @Test
    public void findById() throws Exception {
        final Flight flight = new Flight();

        when(repository.findOne(any(Long.class))).thenReturn(flight);

        Flight resultFlight = service.findById(1L);

        verify(repository, times(1)).findOne(1L);
        assertEquals("Should return a valid flight", flight, resultFlight);
    }

}