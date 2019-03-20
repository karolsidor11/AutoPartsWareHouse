package pl.sidor.AutoPartsWareHouse.service;

import models.Body;

import java.util.List;

public interface BodyService {

    Body findById(int id);

    List<Body> findAllBody();
}
