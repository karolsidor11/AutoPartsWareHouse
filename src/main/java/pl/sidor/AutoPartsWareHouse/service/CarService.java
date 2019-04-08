package pl.sidor.AutoPartsWareHouse.service;

import models.Car;

import java.util.List;

public interface CarService {

    List<Car> findAllCar();

    Car findById(int id) throws Exception;

    Car saveCar(Car car);
}
