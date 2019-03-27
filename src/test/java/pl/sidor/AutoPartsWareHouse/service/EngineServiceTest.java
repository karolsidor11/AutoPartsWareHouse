package pl.sidor.AutoPartsWareHouse.service;

import models.Engine;
import org.junit.Test;
import pl.sidor.AutoPartsWareHouse.dao.EngineDaoImit;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EngineServiceTest {

    private EngineDaoImit engineDaoImit;

    public EngineServiceTest() {
        engineDaoImit = new EngineDaoImit();
    }

    @Test
    public void findAll_shouldReturnListEngine() {

        // when
        List<Engine> all = engineDaoImit.findAll();

        // then
        assertNotNull(all);
        assertEquals(4, all.size());
        assertEquals(500, all.get(0).getTorque());
    }

    @Test
    public void findById_shouldReturnEngineById() {

        // given
        int id = 1;
        Engine engine = new Engine(1, 2.2, 230, 500);

        //when
        Engine byId = engineDaoImit.findById(id);

        //when
        assertNotNull(byId);
        assertEquals(1, byId.getId());
        assertEquals(500, byId.getTorque());
        assertEquals(engine, byId);
    }

    @Test(expected = NullPointerException.class)
    public void findById_shouldReturnExceptionWhenIdIsNegative() {

        //given
        int id = -100;

        // when
        Engine byId = engineDaoImit.findById(id);

        // then
        assertEquals(-100, byId.getId());
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_shouldReturnNotFoundEngine() {

        // given
        int id = 1000;

        // when

        Engine byId = engineDaoImit.findById(id);

        //   then
        assertEquals(1000, byId.getId());

    }


}
