package pl.sidor.AutoPartsWareHouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.AutoPartsWareHouse.model.Body;
@Repository
public interface BodyRepository extends CrudRepository<Body, Integer> {
}
