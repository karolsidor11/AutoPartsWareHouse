package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.exception.WrongIDException;
import pl.sidor.AutoPartsWareHouse.repository.EngineRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EngineServiceImpl implements EngineService {

    private EngineRepository engineRepository;

    @Autowired
    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public List<Engine> findAll() {
        List<Engine> all = (List<Engine>) engineRepository.findAll();
        return !all.isEmpty() ? all : Collections.emptyList();
    }

    @Override
    public Engine findById(int id) throws WrongIDException, NumberFormatException {
        validateID(id);
        return Optional.of(engineRepository.findById(id)).orElseThrow(WrongIDException::new).get();
    }

    private void validateID(int id) throws WrongIDException {
        if (id <= 0) {
            throw new WrongIDException("Nieprawidłowy  identyfikator ID !!!");
        }
    }
}
