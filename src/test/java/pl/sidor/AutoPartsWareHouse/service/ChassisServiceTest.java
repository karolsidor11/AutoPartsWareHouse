package pl.sidor.AutoPartsWareHouse.service;

import models.Chassis;
import org.junit.Test;
import pl.sidor.AutoPartsWareHouse.dao.ChassisDaoImit;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ChassisServiceTest {

    private ChassisDaoImit chassisDaoImit;

    public ChassisServiceTest() {
        chassisDaoImit = new ChassisDaoImit();
    }

    @Test
    public void shouldFindChassisByID() {

        // given
        int id = 1;

        //  when
        Optional<Chassis> byId = Optional.ofNullable(chassisDaoImit.findById(id));

        // then
        assertEquals(1, byId.get().getId());
        assertNotNull(byId.get());

    }

    @Test(expected = NoSuchElementException.class)
    public void shouldNotFindChassisByID() {

        // given
        int id = 1000;

        // when
        Optional<Chassis> byId = Optional.ofNullable(chassisDaoImit.findById(id));

        //  when
        assertEquals(1000, byId.get().getId());
    }


    @Test(expected = NullPointerException.class)
    public void findById_getChassisByNegativeID() {

        // given
        int id = -1;

        // when
        Chassis byId = chassisDaoImit.findById(id);

        // then
        assertEquals(-1, byId.getId());

    }

    @Test
    public void findAllChassis_shouldGetAllChassis() {

        // when
        List<Chassis> allChassis = chassisDaoImit.findAllChassis();

        //then
        assertNotNull(allChassis);
        assertEquals(4, allChassis.size());
        assertEquals("XDrive", allChassis.get(0).getDrive());

    }
}
