package pl.sidor.AutoPartsWareHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.model.Engine;
import pl.sidor.AutoPartsWareHouse.repository.EngineRepository;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {


    private EngineRepository engineRepository;

    @Autowired
    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public List<Engine> findAll() {
        return (List<Engine>) engineRepository.findAll();
    }

    @Override
    public List<Engine> findByCapacity(double capacity) {

        return engineRepository.findByCapacity(capacity);
    }

    @Override
    public List<Engine> findByPower(int power) {

        return engineRepository.findByPower(power);
    }
}
