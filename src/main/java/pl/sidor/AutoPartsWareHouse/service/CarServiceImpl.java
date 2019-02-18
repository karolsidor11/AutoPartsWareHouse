package pl.sidor.AutoPartsWareHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.model.Car;
import pl.sidor.AutoPartsWareHouse.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements  CarService {

    private  CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Optional<List<Car>> findAllCar() {
        return Optional.ofNullable((List<Car>)carRepository.findAll());
    }

    @Override
    public Optional<Car> findById(int id) {
        return Optional.ofNullable(carRepository.findById(id).get());
    }

    @Override
    public Optional<Car> saveCar(Car car) {
        return Optional.ofNullable(carRepository.save(car));
    }
}
