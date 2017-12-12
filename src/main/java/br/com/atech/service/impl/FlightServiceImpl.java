package br.com.atech.service.impl;

import br.com.atech.entity.Flight;
import br.com.atech.repository.FlightRepository;
import br.com.atech.service.FlightService;
import br.com.atech.specification.FlightSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andre on 10/12/2017.
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;

    @Autowired
    public FlightServiceImpl(FlightRepository repository) {
        this.repository = repository;
    }

    @Override
    public  Page<Flight> findAll(FlightSpecification specification, Pageable pageable){ return this.repository.findAll(specification, pageable);}

    @Override
    public Flight findById(Long id) {
        return this.repository.findOne(id);
    }
}
