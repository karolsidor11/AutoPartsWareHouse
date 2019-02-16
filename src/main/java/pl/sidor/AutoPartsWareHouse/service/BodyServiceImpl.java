package pl.sidor.AutoPartsWareHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.model.Body;
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;

import java.util.Optional;

@Service
public class BodyServiceImpl implements BodyService {


    private BodyRepository bodyRepository;

    @Autowired
    public BodyServiceImpl(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    @Override
    public Optional<Body> findById(int id) {
        Optional<Body> byId = bodyRepository.findById(id);

        if (byId.get() != null) {
            return byId;
        } else {
            return Optional.empty();
        }
    }
}
