package br.com.atech.specification;

import br.com.atech.entity.Flight;
import br.com.atech.specification.search.FlightSearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 11/12/2017.
 */
public class FlightSpecification implements Specification<Flight> {

    private FlightSearch criteria;

    public FlightSpecification(FlightSearch flightSearch){
        this.criteria = flightSearch;
    }

    @Override
    public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

        Path departureCity = root.get("departureCity").get("name");
        Path arrivalCity = root.get("arrivalCity").get("name");
        Path status = root.get("status").get("name");

        final List<Predicate> predicates = new ArrayList<Predicate>();

        if(criteria.getDepartureCity() != null){
            predicates.add(cb.like(cb.lower(departureCity), "%"+criteria.getDepartureCity().toLowerCase()+"%"));
        }

        if(criteria.getArrivalCity() != null){
            predicates.add(cb.like(cb.lower(arrivalCity), "%"+criteria.getArrivalCity().toLowerCase()+"%"));
        }

        if(criteria.getStatus() != null) {
            predicates.add(cb.like(cb.lower(status), "%"+criteria.getStatus().toLowerCase()+"%"));
        }

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
