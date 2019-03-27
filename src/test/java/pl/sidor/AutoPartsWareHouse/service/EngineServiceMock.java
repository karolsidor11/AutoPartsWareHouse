package pl.sidor.AutoPartsWareHouse.service;

import models.Engine;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sidor.AutoPartsWareHouse.repository.EngineRepository;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EngineServiceMock {

    @Mock
    private EngineRepository engineRepository;
    @Mock
    private EngineService engineService;

    @BeforeEach
    public void setUp() throws Exception {
        engineRepository = mock(EngineRepository.class);
        engineService = new EngineServiceImpl(engineRepository);
    }

    @Test
    public void findByID_shouldReturnEngineById() {

        //given
        int id = 1;

        //when
        when(engineService.findById(id)).thenReturn(Engine.builder().id(1).capacity(2.2).build());
        Engine byId = engineService.findById(id);

        // then
        assertNotNull(byId);
        assertEquals(1, byId.getId());
        assertEquals(2.2, byId.getCapacity());
    }

    @Test(expected = Exception.class)
    public void findById_shouldReturnException() {

        // given
        int id = -99;

        // when
        doThrow(new Exception("Id nie może być mniejsz od zera")).when(engineService).findById(id);
        Engine byId = engineService.findById(id);

        // then
        assertNotNull(byId);

    }

    @Test
    public void findById_shouldReturnEmptyEngine() {

        // given
        int id = 987;

        //when
        when(engineService.findById(id)).thenReturn(null);
        Engine byId = engineService.findById(id);

        //then
        assertNull(byId);
        assertEquals(null, byId);
    }

    @Test
    public void findAll_shouldReturnEmptyEngineList() {

        //given
        List<Engine> engineList = new ArrayList<>();

        // when
        when(engineService.findAll()).thenReturn(engineList);
        List<Engine> all = engineService.findAll();

        // then
        assertEquals(0, all.size());
    }

    @Test
    public void findAll_shouldReturnListEngine() {

        // given

        List<Engine> engineList = new ArrayList<>();
        Engine engine1 = Engine.builder().id(1).power(123).torque(220).build();
        Engine engine2 = Engine.builder().id(2).power(143).torque(320).build();
        Engine engine3 = Engine.builder().id(3).power(323).torque(420).build();
        Engine engine4 = Engine.builder().id(4).power(223).torque(240).build();

        engineList.add(engine1);
        engineList.add(engine2);
        engineList.add(engine3);
        engineList.add(engine4);

        //when

        when(engineService.findAll()).thenReturn(engineList);
        List<Engine> all = engineService.findAll();

        // then

        assertNotNull(all);
        assertEquals(4, all.size());
        assertEquals(240, all.get(3).getTorque());


    }


}