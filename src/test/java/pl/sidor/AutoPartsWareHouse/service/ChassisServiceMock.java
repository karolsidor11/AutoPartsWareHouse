package pl.sidor.AutoPartsWareHouse.service;

import models.Chassis;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sidor.AutoPartsWareHouse.repository.ChassisRepository;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ChassisServiceMock {

    @Mock
    private ChassisRepository chassisRepository;
    @Mock
    private ChassisService chassisService;

    @BeforeEach
    public void setUp() throws Exception {
        chassisRepository = mock(ChassisRepository.class);
        chassisService = new ChassisServiceImpl(chassisRepository);
    }

    @Test
    public void findById_shouldReturnChassisById() throws Exception {

        //given
        int id = 1;

        // when
        when(chassisService.findById(id)).thenReturn(Chassis.builder().id(1).brakes("Brembo").steering("Xdrive").build());

        // then
        assertEquals(1, chassisService.findById(1).getId());
    }

    @Test(expected = Exception.class)
    public void findById_shouldReturnException() throws Exception {

        //given
        int id = -100;

        //when
        doThrow(new Exception("ID nie może być ujemne")).when(chassisService).findById(id);

        //then
        Chassis byId = chassisService.findById(id);
    }

    @Test
    public void findById_shouldReturnEmptyChassis() throws Exception {

        //given
        int id = 999;

        // when
        when(chassisService.findById(id)).thenReturn(null);
        Chassis byId = chassisService.findById(id);
        // then

        assertNull(chassisService.findById(id));
        assertEquals(null, byId);
    }

    @Test
    public void findAllChassis_shouldReturnEmptyListChassis() {
//        when
        when(chassisService.findAllChassis()).thenReturn(new ArrayList<>());

//        then
        assertNotNull(chassisService.findAllChassis());
        assertEquals(0, chassisService.findAllChassis().size());
    }

    @Test
    public void findAllChassis_shouldReturnChassisList() throws Exception {

//        given

        List<Chassis> chassis = new ArrayList<>();
        Chassis chassis1 = Chassis.builder().id(1).drive("Quattro").brakes("Brembo").build();
        Chassis chassis2 = Chassis.builder().id(2).drive("XDrive").brakes("Brembo").build();
        Chassis chassis3 = Chassis.builder().id(3).drive("4Matic").brakes("Brembo").build();
        chassis.add(chassis1);
        chassis.add(chassis2);
        chassis.add(chassis3);

//        when
         when(chassisService.findAllChassis()).thenReturn(chassis);

//         then

        assertNotNull(chassisService.findAllChassis());
        assertEquals(3, chassisService.findAllChassis().size());
        assertEquals("XDrive", chassisService.findAllChassis().get(1).getDrive());

    }
}