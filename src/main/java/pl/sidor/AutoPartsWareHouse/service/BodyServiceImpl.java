package pl.sidor.AutoPartsWareHouse.service;

import models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BodyServiceImpl implements BodyService {

    private BodyRepository bodyRepository;

    @Autowired
    public BodyServiceImpl(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    @Override
    public Body findById(int id) throws IllegalArgumentException {

        return Optional.of(bodyRepository.findById(id)).orElseThrow(IllegalArgumentException::new).get();

    }

    @Override
    public List<Body> findAllBody() {
        List<Body> all = (List<Body>) bodyRepository.findAll();

        return all.isEmpty() ? all : Collections.emptyList();
    }
}

