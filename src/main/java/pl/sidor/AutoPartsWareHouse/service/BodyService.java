package pl.sidor.AutoPartsWareHouse.service;

import pl.sidor.AutoPartsWareHouse.model.Body;

import java.util.List;
import java.util.Optional;

public interface BodyService {

    Body findById(int id);

    List<Body> findAllBody();
}
