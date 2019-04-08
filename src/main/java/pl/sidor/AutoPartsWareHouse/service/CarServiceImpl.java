package pl.sidor.AutoPartsWareHouse.service;

import models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.repository.CarRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCar() {
        List<Car> all = (List<Car>) carRepository.findAll();

        if (!all.isEmpty()) {
            return all;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Car findById(int id) throws Exception {
        if (id > 0) {
            Optional<Car> byId = carRepository.findById(id);
            return byId.get();
        } else {
            throw new Exception("ID nie może być ujemne!!!");
        }
    }

    @Override
    public Car saveCar(Car car) {
        if (car != null) {
            carRepository.save(car);
            return car;
        } else {
            throw new NullPointerException();
        }
    }
}
