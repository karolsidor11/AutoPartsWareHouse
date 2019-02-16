package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Chassis;

import java.util.Optional;

public interface ChassisService {

    Optional<Chassis> findById(int id);
}
