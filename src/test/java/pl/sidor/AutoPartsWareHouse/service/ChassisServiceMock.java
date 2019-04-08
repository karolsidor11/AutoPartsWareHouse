package pl.sidor.AutoPartsWareHouse.service;

import models.Chassis;
import org.junit.Before;
import org.junit.Test;
import pl.sidor.AutoPartsWareHouse.repository.ChassisRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ChassisServiceMock {

    private ChassisRepository chassisRepository;
    private ChassisService chassisService;

    @Before
    public void setUp() {
        chassisRepository = mock(ChassisRepository.class);
        chassisService = new ChassisServiceImpl(chassisRepository);
    }

    @Test
    public void findById_shouldReturnChassisById() throws Exception {

        //given
        int id = 1;
        Chassis chassis = Chassis.builder().id(1).brakes("Brembo").steering("XDrive").build();
        when(chassisRepository.findById(id)).thenReturn(Optional.of(chassis));

        // when
        Chassis byId = chassisService.findById(id);

        // then
        assertEquals(1, byId.getId());
    }

    @Test(expected = Exception.class)
    public void findById_shouldReturnException() throws Exception {

        //given
        int id = -100;
        doThrow(new Exception("ID nie może być ujemne")).when(chassisRepository).findById(id);

        //when
        Chassis byId = chassisService.findById(id);

        //then
        assertNotNull(byId);

    }

    @Test(expected = NoSuchElementException.class)
    public void findById_shouldReturnEmptyChassis() throws Exception {

        //given
        int id = 999;
        when(chassisRepository.findById(id)).thenReturn(Optional.empty());

        // when
        Chassis byId = chassisService.findById(id);

        // then
        assertNull(byId);
    }

    @Test
    public void findAllChassis_shouldReturnEmptyListChassis() {

        // given
        List<Chassis> chassis = new ArrayList<>();
        when(chassisRepository.findAll()).thenReturn(chassis);

        //when
        List<Chassis> allChassis = chassisService.findAllChassis();

        // then
        assertNotNull(allChassis);
        assertEquals(0, allChassis.size());
    }

    @Test
    public void findAllChassis_shouldReturnChassisList() throws Exception {

        // given

        List<Chassis> chassis = new ArrayList<>();
        Chassis chassis1 = Chassis.builder().id(1).drive("Quattro").brakes("Brembo").build();
        Chassis chassis2 = Chassis.builder().id(2).drive("XDrive").brakes("Brembo").build();
        Chassis chassis3 = Chassis.builder().id(3).drive("4Matic").brakes("Brembo").build();
        chassis.add(chassis1);
        chassis.add(chassis2);
        chassis.add(chassis3);
        when(chassisRepository.findAll()).thenReturn(chassis);

        // when
        List<Chassis> allChassis = chassisService.findAllChassis();

        // then
        assertNotNull(allChassis);
        assertEquals(3, allChassis.size());
        assertEquals("XDrive", allChassis.get(1).getDrive());

    }
}