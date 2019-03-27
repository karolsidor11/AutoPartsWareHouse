package pl.sidor.AutoPartsWareHouse.service;

import models.Body;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BodyServiceMock {

    @Mock
    private BodyService bodyService;
    @Mock
    private BodyRepository bodyRepository;

    @BeforeEach
    public void before() {
        bodyRepository = mock(BodyRepository.class);
        bodyService = new BodyServiceImpl(bodyRepository);

    }

    @org.junit.Test
    public void findByID_shouldRetrunBodyById() throws Exception {

        // given
        int id = 1;

        //  when
        OngoingStubbing<Body> avant = when(bodyService.findById(id)).thenReturn(Body.builder().id(1).bodyCar("Avant").build());

        // then
        assertNotNull(avant);
        assertEquals(1, bodyService.findById(1).getId());
        assertEquals("Avant", bodyService.findById(1).getBodyCar());
    }

    @Test
    public void findById_shouldEmptyBody() throws Exception {

        //given
        int id = 1000;

        //when
        when(bodyService.findById(id)).thenReturn(null);

        //then
        assertNull(bodyService.findById(id));
        assertEquals(null, bodyService.findById(id));
    }

    @Test(expected = Exception.class)
    public void findByID_shouldReturnException() throws Exception {
        //  given
        int id = -2;

        // when
        doThrow(new Exception("Id nie może być ujemne")).when(bodyService).findById(id);
        Body byId = bodyService.findById(id);

        // then
        assertNotNull(byId);
    }

    @Test
    public void findAllBody_shouldReturnEmptyList() {

        // when
        when(bodyService.findAllBody()).thenReturn(Collections.emptyList());

        // then
        assertNotNull(bodyService.findAllBody());
        assertEquals(Collections.EMPTY_LIST, bodyService.findAllBody());
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

        // when
        when(bodyService.findAllBody()).thenReturn(bodyList);

        // then
        assertNotNull(bodyService.findAllBody());
        assertEquals(3, bodyService.findAllBody().size());
        assertEquals("Green", bodyService.findAllBody().get(1).getColor());
    }
}
