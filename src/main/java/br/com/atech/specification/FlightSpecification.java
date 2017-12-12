package br.com.atech.specification;

import br.com.atech.entity.Flight;
import br.com.atech.specification.search.FlightSearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by andre on 11/12/2017.
 */
public class FlightSpecification implements Specification<Flight> {

    private FlightSearch citeria;

    public FlightSpecification(FlightSearch flightSearch){
        this.citeria = flightSearch;
    }

    @Override
    public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
