package pl.sidor.AutoPartsWareHouse.dao;

import models.Body;
import pl.sidor.AutoPartsWareHouse.service.BodyService;

import java.util.ArrayList;
import java.util.List;

public class BodyDaoImit implements BodyService {

    private List<Body> bodyList;

    public BodyDaoImit() {
        bodyList = new ArrayList<>();

        bodyList.add(new Body(1, "Avant", "Red", 5));
        bodyList.add(new Body(2, "Hatcback", "Red", 4));
        bodyList.add(new Body(3, "Sedan", "Green", 5));
        bodyList.add(new Body(4, "Avant", "Blue", 4));
    }

    @Override
    public Body findById(int id) {
        return bodyList.stream().filter(body -> body.getId() == id).findFirst().get();
    }

    @Override
    public List<Body> findAllBody() {
        return bodyList;
    }
}
