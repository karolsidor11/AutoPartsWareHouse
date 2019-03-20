package pl.sidor.AutoPartsWareHouse.service;

import models.Chassis;

import java.util.List;
import java.util.Optional;

public interface ChassisService {

    Chassis findById(int id);

    List<Chassis> findAllChassis();
}
