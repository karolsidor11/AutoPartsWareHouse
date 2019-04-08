package pl.sidor.AutoPartsWareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import models.Chassis;
import pl.sidor.AutoPartsWareHouse.service.ChassisService;

import java.util.List;
import java.util.Optional;

@RestController
public class ChassisController {

    private ChassisService chassisService;

    @Autowired
    public ChassisController(ChassisService chassisService) {
        this.chassisService = chassisService;
    }

    @RequestMapping(value = "chassis/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chassis> findById(@PathVariable int id) throws Exception {

        Optional<Chassis> byId = Optional.ofNullable(chassisService.findById(id));

        HttpStatus httpStatus = byId.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return byId.map(chassis -> new ResponseEntity<>(byId.get(), httpStatus)).orElseGet(()->new ResponseEntity<>(httpStatus));
    }

    @RequestMapping(value = "chassis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chassis>> getAllChassis() {

        Optional<List<Chassis>> allChassis = Optional.ofNullable(chassisService.findAllChassis());

        HttpStatus httpStatus = HttpStatus.OK;

        return  allChassis.map(chassis -> new ResponseEntity<>(allChassis.get(), httpStatus)).orElse(new ResponseEntity<>(httpStatus));
    }
}
