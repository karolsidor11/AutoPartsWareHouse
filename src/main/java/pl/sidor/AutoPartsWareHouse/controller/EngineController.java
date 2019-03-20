package pl.sidor.AutoPartsWareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import models.Engine;
import pl.sidor.AutoPartsWareHouse.service.EngineService;

import java.util.List;
import java.util.Optional;

@RestController
public class EngineController {

    private EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping(name = "engines", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> getAllEngine() {

        Optional<List<Engine>> all = Optional.ofNullable(engineService.findAll());

        HttpStatus httpStatus = HttpStatus.OK;

        return all.map(engines -> new ResponseEntity<>(all.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    @RequestMapping(value = "engine/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Engine> getEngineById(@PathVariable int id) {

        Optional<Engine> byId = Optional.ofNullable(engineService.findById(id));

        HttpStatus httpStatus = HttpStatus.OK;

        return byId.map(engine -> new ResponseEntity<>(byId.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));
    }
}
