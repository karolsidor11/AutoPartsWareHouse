package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.exception.WrongIDException;
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BodyServiceImpl implements BodyService {

    private BodyRepository bodyRepository;

    @Autowired
    public BodyServiceImpl(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    @Override
    public Body findById(int id) throws WrongIDException, NumberFormatException {
        validateID(id);
        return Optional.of(bodyRepository.findById(id)).orElseThrow(WrongIDException::new).get();
    }

    @Override
    public List<Body> findAllBody() {
        List<Body> all = (List<Body>) bodyRepository.findAll();
        return !all.isEmpty() ? all : Collections.emptyList();
    }

    private void validateID(int id) throws WrongIDException {
        if (id <= 0) {
            throw new WrongIDException("Nieprawidłowy  identyfikator ID !!!");
        }
    }
}

