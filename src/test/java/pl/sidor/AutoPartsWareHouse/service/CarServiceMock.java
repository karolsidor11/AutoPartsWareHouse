package pl.sidor.AutoPartsWareHouse.service;

import models.Car;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sidor.AutoPartsWareHouse.exception.IncorrectObjectException;
import pl.sidor.AutoPartsWareHouse.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceMock {

    @Mock
    private CarRepository carRepository;
    @Mock
    private CarService carService;

    @BeforeEach
    public void setUp() throws Exception {

        carRepository = mock(CarRepository.class);
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    public void findAllCar_shouldReturnEmptyListCar() {

        // given
        List<Car> carList = new ArrayList<>();

        //when
        when(carService.findAllCar()).thenReturn(carList);
        List<Car> allCar = carService.findAllCar();

        //then
        assertEquals(0, allCar.size());
    }


    @Test
    public void findAllCar_shouldReturnCarList() {

        // given
        List<Car> cars = new ArrayList<>();
        Car car = Car.builder().id(1).name("Audi").models("A6").color("Blue").build();
        Car car2 = Car.builder().id(2).name("BMW").models("M5").color("Blue").build();
        Car car3 = Car.builder().id(3).name("Volvo").models("S80").color("Blue").build();
        Car car4 = Car.builder().id(4).name("Opel").models("Corsa").color("Blue").build();
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        // when
        when(carService.findAllCar()).thenReturn(cars);
        List<Car> allCar = carService.findAllCar();

        // then
        assertNotNull(allCar);
        assertEquals(4, allCar.size());
        assertEquals("BMW", carService.findAllCar().get(1).getName());
    }

    @Test
    public void findById_shouldReturnCarById() throws Exception {

        // given
        int id = 3;
        Car car = Car.builder().id(3).name("BMW").models("M5").build();

        // when
        when(carService.findById(id)).thenReturn(car);
        Car byId = carService.findById(id);

        //then
        assertNotNull(byId);
        assertEquals(3, byId.getId());
        assertEquals("BMW", byId.getName());
    }

    @Test(expected = Exception.class)
    public void findById_shouldReturnEmptyCar() throws Exception {

        //given
        int id = -999;

        // when
        doThrow(new Exception()).when(carService).findById(id);
        Car byId = carService.findById(id);
    }


    @Test
    public void saveCar_shouldSaveCar() throws IncorrectObjectException {

        // given
        Car audi = Car.builder().id(1).name("Audi").models("A8").color("Black").build();

        //when
        when(carService.saveCar(audi)).thenReturn(audi);
        Car car = carService.saveCar(audi);

        //then

        assertNotNull(car);
        assertEquals(1, car.getId());
        assertEquals("Audi", car.getName());
    }

    @Test(expected = Exception.class)
    public void saveCar_shouldRetrunException() throws IncorrectObjectException {
        //given
        Car car = null;

        //when
        doThrow(new Exception("Car is Null!!!")).when(carService).saveCar(car);
        carService.saveCar(car);

    }


}