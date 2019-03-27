package pl.sidor.AutoPartsWareHouse.service;

import models.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sidor.AutoPartsWareHouse.repository.CarRepository;

import java.util.Optional;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {


    private CarService carService;

    private CarRepository carRepository;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        carRepository = mock(CarRepository.class);
        carService = new CarServiceImpl(carRepository);

    }


    @Test
    public void findAllCar() {

    }


    @Test
    public void findByID_shouldFindCarById() {

//        given
        int id = 1;

//        when

        Mockito.when(carService.findById(1)).thenReturn(Car.builder().build());

//        then


    }
}
