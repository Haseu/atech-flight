package br.com.atech.service;

import br.com.atech.entity.Flight;
import br.com.atech.specification.FlightSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by andre on 10/12/2017.
 */
public interface FlightService {

    Page<Flight> findAll(FlightSpecification specification, Pageable pageable);

    Flight findById(Long id);
}
