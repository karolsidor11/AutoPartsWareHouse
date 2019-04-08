package pl.sidor.AutoPartsWareHouse.service;

import models.Engine;
import org.junit.Before;
import org.junit.Test;
import pl.sidor.AutoPartsWareHouse.repository.EngineRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

public class EngineServiceMock {

    private EngineRepository engineRepository;
    private EngineService engineService;

    @Before
    public void setUp() {
        engineRepository = mock(EngineRepository.class);
        engineService = new EngineServiceImpl(engineRepository);
    }

    @Test
    public void findByID_shouldReturnEngineById() throws Exception {

        //given
        int id = 1;
        Engine engine= Engine.builder().id(1).power(200).capacity(2.2).build();
        when(engineRepository.findById(id)).thenReturn(Optional.ofNullable(engine));

        //when
        Engine byId = engineService.findById(id);

        // then
        assertNotNull(byId);
        assertEquals(1, byId.getId());
        assertEquals(2.2, byId.getCapacity());
    }

    @Test(expected = Exception.class)
    public void findById_shouldReturnException() throws Exception {

        // given
        int id = -99;

        // when
        doThrow(new Exception("Id nie może być mniejsz od zera")).when(engineRepository).findById(id);
        Engine byId = engineService.findById(id);

        // then
        assertNotNull(byId);

    }

    @Test(expected = NoSuchElementException.class)
    public void findById_shouldReturnEmptyEngine() throws Exception {

        // given
        int id = 987;
        when(engineRepository.findById(id)).thenReturn(Optional.empty());

        //when
        Engine byId = engineService.findById(id);

        //then
        assertNull(byId);
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

        when(engineRepository.findAll()).thenReturn(engineList);

        //when
        List<Engine> all = engineService.findAll();

        // then
        assertNotNull(all);
        assertEquals(4, all.size());
        assertEquals(240, all.get(3).getTorque());
    }
}