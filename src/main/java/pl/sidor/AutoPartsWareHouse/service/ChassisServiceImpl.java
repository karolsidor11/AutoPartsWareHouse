package pl.sidor.AutoPartsWareHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.model.Chassis;
import pl.sidor.AutoPartsWareHouse.repository.ChassisRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ChassisServiceImpl implements ChassisService {

    private ChassisRepository chassisRepository;

    @Autowired
    public ChassisServiceImpl(ChassisRepository chassisRepository) {
        this.chassisRepository = chassisRepository;
    }

    @Override
    public Chassis findById(int id) {
        Optional<Chassis> byId = chassisRepository.findById(id);

        return byId.get();
    }

    @Override
    public List<Chassis> findAllChassis() {
        List<Chassis> all = (List<Chassis>) chassisRepository.findAll();

        if (!all.isEmpty()) {
            return all;
        } else {
            return Collections.emptyList();
        }

    }
}
