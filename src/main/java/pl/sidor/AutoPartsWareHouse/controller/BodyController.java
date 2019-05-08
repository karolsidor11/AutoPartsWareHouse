package pl.sidor.AutoPartsWareHouse.controller;

import models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.AutoPartsWareHouse.exception.WrongIDException;
import pl.sidor.AutoPartsWareHouse.service.BodyService;

import java.util.List;
import java.util.Optional;

@RestController
public class BodyController {

    private BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService) {
        this.bodyService = bodyService;
    }

    @RequestMapping(value = "body/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Body> getBodyByID(@PathVariable int id) throws Exception {

        Optional<Body> byId = Optional.ofNullable(bodyService.findById(id));

        HttpStatus httpStatus = HttpStatus.OK;

        return byId.map(body -> new ResponseEntity<>(byId.get(), httpStatus)).orElseThrow(WrongIDException::new);
    }

    @RequestMapping(value = "bodies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Body>> getAllBody() {

        Optional<List<Body>> allBody = Optional.ofNullable(bodyService.findAllBody());

        HttpStatus httpStatus = HttpStatus.OK;

        return allBody.map(bodies -> new ResponseEntity<>(allBody.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));
    }
}
