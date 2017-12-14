package br.com.atech.specification;

import br.com.atech.entity.Flight;
import br.com.atech.specification.search.FlightSearch;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.persistence.criteria.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by andre on 13/12/2017.
 */
public class FlightSpecificationTest {

    private FlightSpecification specification;

    @Mock
    CriteriaBuilder builder;

    @Mock
    Root<Flight> root;

    @Mock
    CriteriaQuery<?> query;

    @Mock
    Path path;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void toPredicate() throws Exception {

        when(root.get("departureCity")).thenReturn(path);
        when(root.get("departureCity").get("name")).thenReturn(path);
        when(root.get("arrivalCity")).thenReturn(path);
        when(root.get("arrivalCity").get("name")).thenReturn(path);
        when(root.get("status")).thenReturn(path);
        when(root.get("status").get("name")).thenReturn(path);

        FlightSearch search = new FlightSearch();
        this.specification = new FlightSpecification(search);

        assertThat(specification, is(notNullValue()));
        assertThat(specification.toPredicate(root, query, builder), is(nullValue()));
    }



}