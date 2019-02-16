package pl.sidor.AutoPartsWareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.AutoPartsWareHouse.model.Engine;
import pl.sidor.AutoPartsWareHouse.service.EngineService;

import java.util.List;

@RestController
public class EngineController {


    private EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping(name = "allEngine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> getAllEngine() {
        List<Engine> all = engineService.findAll();
        HttpStatus httpStatus = all != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(all, httpStatus);

    }

    @RequestMapping(value = "moc/{power}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> findByPower(@PathVariable int power) {

        List<Engine> byPower = engineService.findByPower(power);

        HttpStatus httpStatus = byPower != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(byPower, httpStatus);
    }

//   ToDo  Parsowanie double ????

    @RequestMapping(value = "pojemność/{capacity}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> findByCapacity(@PathVariable double capacity) {

        List<Engine> byCapacity = engineService.findByCapacity(capacity);

        HttpStatus httpStatus = byCapacity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(byCapacity, httpStatus);
    }
}
