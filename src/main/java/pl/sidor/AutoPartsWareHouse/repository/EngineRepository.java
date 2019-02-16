package pl.sidor.AutoPartsWareHouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.AutoPartsWareHouse.model.Engine;

import java.util.List;

@Repository
public interface EngineRepository extends CrudRepository<Engine, Integer> {

    List<Engine> findByCapacity(double capacity);

    List<Engine> findByPower(int power);

}
