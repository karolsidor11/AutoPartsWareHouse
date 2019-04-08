package pl.sidor.AutoPartsWareHouse.service;

import models.Body;
import org.junit.Before;
import org.junit.Test;
import pl.sidor.AutoPartsWareHouse.dao.BodyDaoImit;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BodyServiceTest {

    private BodyDaoImit bodyDaoImit;

    @Before
    public void setUp() {
        bodyDaoImit = new BodyDaoImit();
    }

    @Test
    public void shouldFindBodyById() {

        //  given
        int id = 1;

        // when
        Body byId = bodyDaoImit.findById(id);

        // then
        assertNotNull(byId);
        assertEquals(1, byId.getId());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldBodyByBadID() {

        // given
        int id = 10000;

        // when
        Body byId = bodyDaoImit.findById(10);

        // then
        assertEquals(10, byId.getId());
    }

    @Test
    public void shouldGetBodyCarById() {

        // given
        int id = 1;
        //  when

        Body byId = bodyDaoImit.findById(id);

        // then
        assertNotNull(byId);
        assertEquals("Avant", byId.getBodyCar());
        assertEquals("Red", byId.getColor());
        assertEquals(5, byId.getDoor());
    }

    @Test
    public void bodyService_shouldReturnListBody() {

        // when
        List<Body> allBody = bodyDaoImit.findAllBody();

        // then
        assertEquals(4, allBody.size());
    }
}
