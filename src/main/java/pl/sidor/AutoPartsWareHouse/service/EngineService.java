package pl.sidor.AutoPartsWareHouse.service;

import models.Engine;

import java.util.List;

public interface EngineService {

    List<Engine> findAll();

    Engine findById(int id);
}
