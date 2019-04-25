package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.repository.CarRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCar() {
        List<Car> all = (List<Car>) carRepository.findAll();

        return !all.isEmpty() ? all : Collections.emptyList();
    }

    @Override
    public Car findById(int id) throws IllegalArgumentException {

        return Optional.of(carRepository.findById(id)).orElseThrow(IllegalArgumentException::new).get();
    }

    @Override
    public Car saveCar(Car car) {
        return getCar(car);
    }

    private Car getCar(Car car) {
        if (car != null) {
            carRepository.save(car);
            return car;
        } else {
            throw new NullPointerException();
        }
    }
}
