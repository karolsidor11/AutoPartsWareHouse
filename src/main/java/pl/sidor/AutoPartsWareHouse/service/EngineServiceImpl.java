package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        return !all.isEmpty() ? all: Collections.emptyList();

    }

    @Override
    public Engine findById(int id) throws Exception {
        if (id >=0) {
            Optional<Engine> byId = engineRepository.findById(id);
            return byId.get();
        } else {
            throw new Exception();
        }
    }
}
