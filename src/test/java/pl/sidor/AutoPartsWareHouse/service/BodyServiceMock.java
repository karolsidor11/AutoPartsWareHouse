package pl.sidor.AutoPartsWareHouse.service;

import models.Body;
import org.junit.Before;
import org.junit.Test;
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BodyServiceMock {

    private BodyService bodyService;
    private BodyRepository bodyRepository;

    @Before
    public void before() {
        bodyRepository = mock(BodyRepository.class);
        bodyService = new BodyServiceImpl(bodyRepository);

    }

    @Test
    public void findByID_shouldRetrunBodyById() throws Exception {

        // given
        int id = 1;
        Body actualBody = Body.builder().id(1).bodyCar("Avant").color("Blue").build();
        when(bodyRepository.findById(id)).thenReturn(Optional.ofNullable(actualBody));

        //  when
        Body byId = bodyService.findById(id);

        // then
        assertNotNull(byId);
        assertEquals(1, byId.getId());
        assertEquals("Avant", byId.getBodyCar());
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_shouldEmptyBody() throws Exception {

        //given
        int id = 1000;
        when(bodyRepository.findById(id)).thenReturn(Optional.empty());

        //when
        Body byId = bodyService.findById(id);

        //then
        assertNull(byId);
    }

    @Test(expected = Exception.class)
    public void findByID_shouldReturnException() throws Exception {

        //  given
        int id = -2;
        doThrow(new Exception("Id nie może być ujemne")).when(bodyRepository).findById(id);

        // when
        Body byId = bodyService.findById(id);

        // then
        assertNotNull(byId);
    }

    @Test
    public void findAllBody_shouldReturnEmptyList() {

        //given
        List<Body> objects = Collections.emptyList();
        when(bodyRepository.findAll()).thenReturn(objects);

        // when
        List<Body> allBody = bodyService.findAllBody();

        // then
        assertEquals(0, allBody.size());
        assertEquals(Collections.EMPTY_LIST, allBody);
    }

    @Test
    public void findAllBody_shouldReturnBodies() {

        // given
        List<Body> bodyList = new ArrayList<>();
        Body body1 = Body.builder().id(1).color("Red").door(4).build();
        Body body2 = Body.builder().id(2).color("Green").door(4).build();
        Body body3 = Body.builder().id(3).color("Red").door(4).build();
        bodyList.add(body1);
        bodyList.add(body2);
        bodyList.add(body3);
        when(bodyRepository.findAll()).thenReturn(bodyList);


        // when
        List<Body> allBody = bodyService.findAllBody();

        // then
        assertNotNull(allBody);
        assertEquals(3, allBody.size());
        assertEquals("Green", allBody.get(1).getColor());
    }
}
