package pl.sidor.AutoPartsWareHouse.repository;

import models.Chassis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChassisRepository extends CrudRepository<Chassis, Integer> {
}
