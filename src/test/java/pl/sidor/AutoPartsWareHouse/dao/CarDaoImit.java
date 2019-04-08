package pl.sidor.AutoPartsWareHouse.dao;

import models.Car;
import pl.sidor.AutoPartsWareHouse.service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImit implements CarService {

    private List<Car> carList;

    public CarDaoImit() {
        carList = new ArrayList<>();
        carList.add(Car.builder().name("Audi").models("A6").color("Blue").id(1).build());
        carList.add(Car.builder().name("Audi").models("A5").color("Violet").id(2).build());
        carList.add(Car.builder().name("BMW").models("M5").color("Greeb").id(3).build());
        carList.add(Car.builder().name("Volvo").models("S80").color("Red").id(4).build());
    }

    @Override
    public List<Car> findAllCar() {
        return carList;
    }

    @Override
    public Car findById(int id) {
        if (id > 0) {
            return carList.stream().filter(car -> car.getEngine().equals(id)).findFirst().get();
        }
        throw new NullPointerException("Id nie może być mniejsze od 0 !!!");
    }

    @Override
    public Car saveCar(Car car) {
        carList.add(car);
        return car;
    }
}
