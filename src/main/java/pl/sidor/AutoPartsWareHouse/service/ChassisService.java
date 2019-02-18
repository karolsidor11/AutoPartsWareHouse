package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Chassis;

import java.util.List;
import java.util.Optional;

public interface ChassisService {

    Chassis findById(int id);

    List<Chassis> findAllChassis();
}
