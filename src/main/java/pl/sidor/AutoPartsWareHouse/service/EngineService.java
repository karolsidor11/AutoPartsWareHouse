package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Engine;

import java.util.List;

public interface EngineService {

    List<Engine> findAll();

    List<Engine> findByCapacity(double capacity);

    List<Engine> findByPower(int power);
}
