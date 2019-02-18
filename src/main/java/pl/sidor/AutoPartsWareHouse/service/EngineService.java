package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Engine;

import java.util.List;

public interface EngineService {

    List<Engine> findAll();

    Engine findById(int id);
}
