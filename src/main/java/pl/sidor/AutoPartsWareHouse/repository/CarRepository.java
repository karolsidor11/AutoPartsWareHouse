package pl.sidor.AutoPartsWareHouse.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sidor.AutoPartsWareHouse.model.Car;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
