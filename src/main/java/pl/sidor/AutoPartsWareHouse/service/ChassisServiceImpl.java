package pl.sidor.AutoPartsWareHouse.service;

import models.Chassis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Chassis findById(int id) throws Exception {
        if (id != 0 && id > 0) {
            Optional<Chassis> byId = chassisRepository.findById(id);
            return byId.get();
        }
        throw new Exception("Id musibyć większę od zero");

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
