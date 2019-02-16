package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Body;

import java.util.Optional;

public interface BodyService {

    Optional<Body> findById(int id);
}
