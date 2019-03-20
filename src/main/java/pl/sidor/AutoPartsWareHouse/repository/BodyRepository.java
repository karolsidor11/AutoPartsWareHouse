package pl.sidor.AutoPartsWareHouse.repository;

import models.Body;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends CrudRepository<Body, Integer> {
}
