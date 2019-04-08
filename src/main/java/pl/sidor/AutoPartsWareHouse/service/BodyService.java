package pl.sidor.AutoPartsWareHouse.service;

import models.Body;

import java.util.List;

public interface BodyService {

    Body findById(int id) throws Exception;

    List<Body> findAllBody();
}
