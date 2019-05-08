package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.Chassis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.exception.WrongIDException;
import pl.sidor.AutoPartsWareHouse.repository.ChassisRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ChassisServiceImpl implements ChassisService {

    private ChassisRepository chassisRepository;

    @Autowired
    public ChassisServiceImpl(ChassisRepository chassisRepository) {
        this.chassisRepository = chassisRepository;
    }

    @Override
    public Chassis findById(int id) throws WrongIDException, NumberFormatException {
        validateID(id);
        return Optional.of(chassisRepository.findById(id)).orElseThrow(WrongIDException::new).get();
    }

    @Override
    public List<Chassis> findAllChassis() {
        List<Chassis> all = (List<Chassis>) chassisRepository.findAll();

        return !all.isEmpty() ? all : Collections.emptyList();
    }

    private void validateID(int id) throws WrongIDException {
        if (id <= 0) {
            throw new WrongIDException("Nieprawidłowy  identyfikator ID !!!");
        }
    }
}
