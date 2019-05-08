package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.exception.IncorrectObjectException;
import pl.sidor.AutoPartsWareHouse.exception.WrongIDException;
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
    public Car findById(int id) throws WrongIDException {
        validateID(id);
        return Optional.of(carRepository.findById(id)).orElseThrow(WrongIDException::new).get();
    }

    @Override
    public Car saveCar(Car car) throws IncorrectObjectException {

        validateObject(car);
        return carRepository.save(car);
    }

    private void validateID(int id) throws WrongIDException, NumberFormatException {
        if (id <= 0) {
            throw new WrongIDException("Nieprawidłowy  identyfikator ID !!!");
        }
    }

    private void validateObject(Object object) throws IncorrectObjectException {
        if (object != null) {
        } else {
            throw new IncorrectObjectException("Niepoprawny obiekt !!!");
        }
    }
}
