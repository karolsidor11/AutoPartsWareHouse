package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<List<Car>> findAllCar();

    Optional<Car> findById(int id);

    Optional<Car> saveCar(Car car);
}
